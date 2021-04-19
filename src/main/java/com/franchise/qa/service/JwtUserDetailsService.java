package com.franchise.qa.service;

import com.franchise.qa.dto.TokenDTO;
import com.franchise.qa.dto.UserDTO;
import com.franchise.qa.persistance.entity.ExpiredToken;
import com.franchise.qa.persistance.entity.User;
import com.franchise.qa.persistance.repository.ExpiredTokenRepository;
import com.franchise.qa.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Created by noravingal on 16/04/21.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private ExpiredTokenRepository expiredTokenRepository;

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.isAccountNonExpired();
        newUser.isAccountNonLocked();
        newUser.isCredentialsNonExpired();
        newUser.isEnabled();
        return userRepository.save(newUser);
    }

    public ExpiredToken expireToken(TokenDTO tokenDTO){
        ExpiredToken expiredToken = new ExpiredToken();
        expiredToken.setToken(tokenDTO.getToken());
        expiredToken.setUsername(tokenDTO.getUsername());
        return expiredTokenRepository.save(expiredToken);
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                new ArrayList<>());
         }
}
