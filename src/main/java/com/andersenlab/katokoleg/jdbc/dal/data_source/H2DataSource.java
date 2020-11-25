package com.andersenlab.katokoleg.jdbc.dal.data_source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DataSource implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'C:/Users/Олег/IdeaProjects/Andersen-internship/src/main/resources/create.sql'\\;runscript from 'C:/Users/Олег/IdeaProjects/Andersen-internship/src/main/resources/init.sql'", "user", "password");
    }
}
