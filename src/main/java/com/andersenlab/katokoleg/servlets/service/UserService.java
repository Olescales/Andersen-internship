package com.andersenlab.katokoleg.servlets.service;

import com.andersenlab.katokoleg.servlets.dto.UserDTO;
import com.andersenlab.katokoleg.servlets.exception.InvalidPasswordException;
import com.andersenlab.katokoleg.servlets.exception.NoSuchUserException;

public interface UserService {

    UserDTO signIn(String login, String password) throws NoSuchUserException, InvalidPasswordException;
}
