package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import org.hibernate.Session;

import java.util.Set;

public class UserDALImpl implements UserDAL {

    @Override
    public Set<UserRole> getUserRoles(long userID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User requiredUser = session.get(User.class, userID);
            session.getTransaction().commit();
            return requiredUser.getRoles();
        }
    }
}
