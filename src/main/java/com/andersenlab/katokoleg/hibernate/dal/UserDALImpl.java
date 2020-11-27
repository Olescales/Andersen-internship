package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.HibernateUtil;
import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;
import org.hibernate.Session;

import java.util.List;

public class UserDALImpl implements UserDAL {

    @Override
    public List<UserRole> getUserRoles(long userID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User requiredUser = session.get(User.class, userID);
            return requiredUser.getRoles();
        }
    }
}
