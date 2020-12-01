package com.andersenlab.katokoleg.servlets.dto;

import com.andersenlab.katokoleg.servlets.entity.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String login;
    private String password;
    private Set<UserRole> roles;

    public UserDTO(long id, String login, String password, Set<UserRole> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

}