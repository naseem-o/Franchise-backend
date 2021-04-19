package com.franchise.qa.auditlog;

import com.franchise.qa.persistance.entity.AuditLog;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by noravingal on 10/04/21.
 */
@Component
public class CustomHttpTraceFilter extends OncePerRequestFilter {

    private AuditLog auditLog;

    private final long startTime = System.currentTimeMillis();

   private final AuditLogEventHandler auditLogEventHandler;

    public CustomHttpTraceFilter(AuditLogEventHandler auditLogEventHandler) {
        this.auditLogEventHandler = auditLogEventHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws
                                    ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper =
                new ContentCachingRequestWrapper(request);

        ContentCachingResponseWrapper responseWrapper =
                new ContentCachingResponseWrapper(response);
        auditLog = new AuditLog();
        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            afterRequest(requestWrapper, responseWrapper);
        }
    }


    private void afterRequest(ContentCachingRequestWrapper requestWrapper,
                              ContentCachingResponseWrapper responseWrapper)
            throws IOException {
         /*
         *  From Request Headers
         */

        String method = requestWrapper.getMethod();
       /* boolean isGetMethod = method.equals("GET");
        // At the moment get requests are not being tracked
        if (isGetMethod) {
            responseWrapper.copyBodyToResponse();
            return;
        }*/

        auditLog.setTimeTaken(System.currentTimeMillis() - startTime);
        auditLog.setMethod(method);
        auditLog.setRemoteAddress(requestWrapper.getRemoteAddr());
        auditLog.setUri(requestWrapper.getRequestURI());

        auditLog.setHost(requestWrapper.getHeader("host"));
        auditLog.setAuthorization(requestWrapper.getHeader("authorization"));
        auditLog.setUserAgent(requestWrapper.getHeader("user-agent"));
        auditLog.setReferer(requestWrapper.getHeader("referer"));

        auditLog.setReqBody(getRequestPayload(requestWrapper));

        /*
         *  From Response Headers
         */

        auditLog.setStatus(responseWrapper.getStatusCode());

        auditLog.setResBody(getResponsePayload(responseWrapper));

         /*
         * Important to copy the original response body, because it is removed.
         */

        responseWrapper.copyBodyToResponse();

        // save to database
        auditLogEventHandler.auditLogEventListener(auditLog);
    }

    private String getRequestPayload(HttpServletRequest request) {
        ContentCachingRequestWrapper wrapper =
                WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                int length = buf.length;
                try {
                    return new String(buf, 0, length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException ex) {
                    return "[unknown]";
                }
            }
        }
        return "";
    }

    private String getResponsePayload(ContentCachingResponseWrapper wrappedResponse) {
        try {
            if (wrappedResponse.getContentSize() <= 0) {
                return null;
            }
            return new String(wrappedResponse.getContentAsByteArray(), 0,
                    wrappedResponse.getContentSize(),
                    wrappedResponse.getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            logger.error(
                    "Could not read cached response body: " + e.getMessage());
            return null;
        }
    }

    }

