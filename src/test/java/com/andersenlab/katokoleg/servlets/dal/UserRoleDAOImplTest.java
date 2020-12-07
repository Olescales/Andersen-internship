package com.andersenlab.katokoleg.servlets.dal;

import com.andersenlab.katokoleg.servlets.entity.Role;
import com.andersenlab.katokoleg.servlets.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.Set;

@RunWith(JUnit4.class)
public class UserRoleDAOImplTest {

    private UserRoleDAO userRoleDAO;

    @Before
    public void init() {
        userRoleDAO = new UserRoleDAOImpl();
    }

    @Test
    public void getUsersByRoleGuest() {
        Set<User> actual = userRoleDAO.getUsersByRole(Role.GUEST);
        Set<User> expected = Collections.emptySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUsersByRoleUser() {
        Set<User> actual = userRoleDAO.getUsersByRole(Role.USER);
        Set<User> expected = Set.of(new User("moneta", "123"), new User("igorek", "123"));
        Assert.assertEquals(expected, actual);
    }
}