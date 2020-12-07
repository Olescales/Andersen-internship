package com.andersenlab.katokoleg.servlets.dal;

import com.andersenlab.katokoleg.servlets.entity.Role;
import com.andersenlab.katokoleg.servlets.entity.User;

import java.util.Set;

public interface UserRoleDAO {

    Set<User> getUsersByRole (Role role);
}
