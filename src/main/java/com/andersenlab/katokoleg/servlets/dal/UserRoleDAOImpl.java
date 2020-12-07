package com.andersenlab.katokoleg.servlets.dal;

import com.andersenlab.katokoleg.servlets.entity.Role;
import com.andersenlab.katokoleg.servlets.entity.User;
import com.andersenlab.katokoleg.servlets.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.Set;

public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public Set<User> getUsersByRole(Role role) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select distinct ur from UserRole ur inner join fetch ur.users u where ur.role = :role");
        query.setParameter("role", role);
        UserRole desiredUsers = null;
        try {
            desiredUsers = (UserRole) query.getSingleResult();
        } catch (NoResultException ignored) {

        }
        transaction.commit();
        session.close();
        if (desiredUsers != null) {
            return desiredUsers.getUsers();
        } else {
            return Collections.emptySet();
        }
    }
}
