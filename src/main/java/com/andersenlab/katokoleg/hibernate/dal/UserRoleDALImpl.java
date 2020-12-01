package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.Role;
import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import org.hibernate.Session;

import java.util.Set;

public class UserRoleDALImpl implements UserRoleDAL {
    @Override
    public Set<User> getUsers(Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Set<User> users = session.get(UserRole.class, (long)role.ordinal()).getUsers();
            session.getTransaction().commit();
            return users;
        }
    }
}
