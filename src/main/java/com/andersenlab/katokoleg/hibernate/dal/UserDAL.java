package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.entity.UserRole;

import java.util.Set;

public interface UserDAL {

    Set<UserRole> getUserRoles(long userID);

}
