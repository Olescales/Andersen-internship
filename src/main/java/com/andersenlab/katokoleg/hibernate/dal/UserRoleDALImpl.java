package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.Role;
import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import org.hibernate.Session;

import java.util.List;

public class UserRoleDALImpl implements UserRoleDAL {
    @Override
    public List<User> getUsers(Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<User> users = session.get(UserRole.class, 2L).getUsers();
            session.getTransaction().commit();
            return users;
        }
    }
}
