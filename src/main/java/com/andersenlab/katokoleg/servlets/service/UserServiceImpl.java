package com.andersenlab.katokoleg.servlets.service;

import com.andersenlab.katokoleg.servlets.controller.security.PasswordAuthenticator;
import com.andersenlab.katokoleg.servlets.dal.UserDAO;
import com.andersenlab.katokoleg.servlets.dto.UserDTO;
import com.andersenlab.katokoleg.servlets.entity.User;
import com.andersenlab.katokoleg.servlets.exception.InvalidPasswordException;
import com.andersenlab.katokoleg.servlets.exception.NoSuchUserException;
import com.andersenlab.katokoleg.servlets.mapper.Mapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private Mapper<UserDTO, User> userMapper;
    private PasswordAuthenticator passwordAuthenticator;

    @Override
    public UserDTO signIn(String login, String password) throws NoSuchUserException, InvalidPasswordException {
        User desiredUser = userDAO.getUserByLoginAndPassword(login, password);
        if (desiredUser == null) {
            throw new NoSuchUserException("User with login " + login + " not exist");
        }
        /*if (!passwordAuthenticator.authenticate(userDTO.getPassword().toCharArray(), desiredUser.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }*/
        return userMapper.fromEntityToDTO(desiredUser);
    }
}