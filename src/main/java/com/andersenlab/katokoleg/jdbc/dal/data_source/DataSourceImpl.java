package com.andersenlab.katokoleg.jdbc.dal.data_source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceImpl implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from '~/create.sql'\\;runscript from '~/init.sql'", "user", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
