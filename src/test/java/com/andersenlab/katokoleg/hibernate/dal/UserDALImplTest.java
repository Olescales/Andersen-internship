package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.Role;
import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import org.hibernate.Session;
import org.junit.After;
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
    private UserRoleDAL userRoleDAL;

    @Before
    public void init() {
        userDAL = new UserDALImpl();
        userRoleDAL = new UserRoleDALImpl();
        UserRole admin = new UserRole(Role.ADMIN);
        UserRole user = new UserRole(Role.USER);
        User moneta = new User("moneta", "123", admin, user);
        User igorek = new User("igorek", "123", user);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(moneta);
        session.save(igorek);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetUserRolesOne() {
        List<UserRole> roleUsers = userDAL.getUserRoles(1L);
        List<UserRole> expectedRoles = new ArrayList(List.of(new UserRole(Role.ADMIN), new UserRole(Role.USER)));
        Assert.assertEquals(expectedRoles, roleUsers);
    }

    @Test
    public void testGetUserRolesTwo() {
        List<UserRole> roleUsers = userDAL.getUserRoles(2L);
        List<UserRole> expectedRoles = new ArrayList(List.of(new UserRole(Role.USER)));
        Assert.assertEquals(expectedRoles, roleUsers);
    }

    @Test
    public void testGetRoleUsersTwo() {
        List<User> users = userRoleDAL.getUsers(Role.USER);
        Assert.assertEquals(2, users.size());
    }

    /*@After
    public void dest() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User moneta = session.load(User.class, 1L);
        User igorek = session.load(User.class, 2L);
        session.delete(moneta);
        session.delete(igorek);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }*/
}