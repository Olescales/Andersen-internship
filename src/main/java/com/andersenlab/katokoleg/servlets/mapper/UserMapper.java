package com.andersenlab.katokoleg.servlets.mapper;

import com.andersenlab.katokoleg.servlets.dto.UserDTO;
import com.andersenlab.katokoleg.servlets.entity.User;

public class UserMapper implements Mapper<UserDTO, User> {

    @Override
    public User fromDTOToEntity(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getId() > 0) {
            user.setId(userDTO.getId());
        }
        if (userDTO.getLogin() != null) {
            user.setLogin(userDTO.getLogin());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }

        return user;
    }

    @Override
    public UserDTO fromEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        if (user.getId() > 0) {
            userDTO.setId(user.getId());
        }
        if (user.getLogin() != null) {
            userDTO.setLogin(user.getLogin());
        }
        if (user.getPassword() != null) {
            userDTO.setPassword(user.getPassword());
        }
        if (!user.getRoles().isEmpty()) {
            userDTO.setRoles(user.getRoles());
        }
        return userDTO;
    }
}