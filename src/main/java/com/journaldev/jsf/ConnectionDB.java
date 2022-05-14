package com.journaldev.jsf;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/books";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private static DataSource getDataSource () {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl (JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);

        return ds;
    }

    public static Connection getConnection () throws SQLException {
        return getDataSource().getConnection();
    }

    public static void Close (ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void Close (PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void Close (Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    }

