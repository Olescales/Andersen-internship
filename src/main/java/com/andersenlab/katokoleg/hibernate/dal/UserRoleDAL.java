package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.entity.User;
import com.andersenlab.katokoleg.hibernate.entity.UserRole;

import java.util.List;

public interface UserRoleDAL {

    List<User> getUsers(UserRole userRole);
}
