package com.andersenlab.katokoleg.jdbc.dal;

import com.andersenlab.katokoleg.jdbc.entity.User;
import com.andersenlab.katokoleg.jdbc.entity.UserRole;

import java.util.List;

public interface UserDAL {

    List<User> getRoleUsers(long roleID);

    List<UserRole> getUserRoles(long userID);

    boolean addUser(User user);
}
