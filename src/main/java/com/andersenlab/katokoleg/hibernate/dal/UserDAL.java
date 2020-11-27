package com.andersenlab.katokoleg.hibernate.dal;

import com.andersenlab.katokoleg.hibernate.entity.UserRole;

import java.util.List;

public interface UserDAL {

    List<UserRole> getUserRoles(long userID);

}
