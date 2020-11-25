package com.andersenlab.katokoleg.jdbc;

import com.andersenlab.katokoleg.jdbc.dal.UserDAL;
import com.andersenlab.katokoleg.jdbc.dal.UserDALImpl;
import com.andersenlab.katokoleg.jdbc.dal.data_source.DataSource;
import com.andersenlab.katokoleg.jdbc.dal.data_source.H2DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new H2DataSource();
        UserDAL userDAL = new UserDALImpl(dataSource);
    }
}
