package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.entity.Role;
import com.andersenlab.katokoleg.hibernate.entity.User;

import java.util.Set;

public interface UserRoleDAL {

    Set<User> getUsers(Role role);
}
