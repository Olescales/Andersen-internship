package com.andersenlab.katokoleg.servlets.service;

import com.andersenlab.katokoleg.servlets.controller.security.PasswordAuthenticator;
import com.andersenlab.katokoleg.servlets.dal.UserDAO;
import com.andersenlab.katokoleg.servlets.dal.UserDAOImpl;
import com.andersenlab.katokoleg.servlets.dto.UserDTO;
import com.andersenlab.katokoleg.servlets.entity.Role;
import com.andersenlab.katokoleg.servlets.entity.User;
import com.andersenlab.katokoleg.servlets.entity.UserRole;
import com.andersenlab.katokoleg.servlets.exception.NoSuchUserException;
import com.andersenlab.katokoleg.servlets.mapper.Mapper;
import com.andersenlab.katokoleg.servlets.mapper.UserMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void init () {
        UserDAO userDAO = new UserDAOImpl();
        Mapper<UserDTO, User> userMapper = new UserMapper();
        PasswordAuthenticator passwordAuthenticator = new PasswordAuthenticator();
        userService = new UserServiceImpl(userDAO, userMapper, passwordAuthenticator);
    }

    @SneakyThrows
    @Test
    public void testSignIn() {
        String login = "moneta";
        String password = "123";
        UserDTO userDTO = userService.signIn(login, password);
        UserDTO expected = new UserDTO(1, "moneta", "123", Stream.of(new UserRole(Role.ADMIN), new UserRole(Role.USER)).collect(Collectors.toSet()));
        Assert.assertEquals(expected, userDTO);
    }
}