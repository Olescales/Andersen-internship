package com.andersenlab.katokoleg.jdbc.dal;

import com.andersenlab.katokoleg.jdbc.dal.data_source.DataSource;
import com.andersenlab.katokoleg.jdbc.dal.data_source.H2DataSource;
import com.andersenlab.katokoleg.jdbc.entity.User;
import com.andersenlab.katokoleg.jdbc.entity.UserRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class UserDALImplTest {

    private UserDAL userDAL;

    @Before
    public void init() {
        DataSource dataSource = new H2DataSource();
        userDAL = new UserDALImpl(dataSource);
    }

    @Test
    public void getRoleUsersTest() {
        List<User> roleUsers = userDAL.getRoleUsers(2L);
        List<User> expected = new ArrayList<>(List.of(new User("moneta", "123"), new User("igorek", "123")));
        Assert.assertEquals(expected, roleUsers);
    }

    @Test
    public void getUserRolesTest() {
        List<UserRole> userRoles = userDAL.getUserRoles(1);
        List<UserRole> expectedRoles = new ArrayList<>(List.of(UserRole.ADMIN, UserRole.USER));
        Assert.assertEquals(expectedRoles, userRoles);
    }

    @Test
    public void addUser() {
        boolean result = userDAL.addUser(new User("nafania", "nafania"));
        Assert.assertFalse(result);
    }
}