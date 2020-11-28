package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.entity.Role;
import com.andersenlab.katokoleg.hibernate.entity.User;

import java.util.List;

public interface UserRoleDAL {

    List<User> getUsers(Role role);
}
