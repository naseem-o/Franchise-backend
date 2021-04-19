package com.franchise.qa.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by noravingal on 15/04/21.
 */
@Data
public class UserDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
