package com.andersenlab.katokoleg.servlets.dal;

import com.andersenlab.katokoleg.servlets.entity.User;

public interface UserDAO {

    User getUserByLoginAndPassword (String login, String password);
}
