package com.andersenlab.katokoleg.servlets.dal;

import com.andersenlab.katokoleg.servlets.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        User desiredUser = (User) query.getSingleResult();
        transaction.commit();
        session.close();
        return desiredUser;
    }
}