package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import com.andersenlab.katokoleg.hibernate.entity.User;
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
    public void init () {
        userDAL = new UserDALImpl();
        User moneta = new User();
        moneta.setLogin("moneta");
        moneta.setPassword("123");
        UserRole admin = new UserRole();
        admin.setName("ADMIN");
        UserRole user = new UserRole();
        user.setName("USER");
        moneta.setRoles(List.of(admin, user));
        User igorek = new User();
        igorek.setLogin("igorek");
        igorek.setPassword("123");
        igorek.setRoles(List.of(user));
        HibernateUtil.getSessionFactory().openSession().save(moneta);
        HibernateUtil.getSessionFactory().openSession().save(igorek);
    }

    @Test
    public void testHibernate() {
        List<UserRole> roleUsers = userDAL.getUserRoles(1L);
        List<UserRole> expectedRoles = new ArrayList(List.of(new UserRole("ADMIN"), new UserRole("USER")));
        Assert.assertEquals(expectedRoles, roleUsers);

    }
}