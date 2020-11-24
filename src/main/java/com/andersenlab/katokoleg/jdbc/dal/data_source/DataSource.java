package com.andersenlab.katokoleg.jdbc.dal.data_source;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataSource {

    Connection getConnection() throws SQLException;
}
