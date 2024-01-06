package com.example.demo.db;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class DB {


    static DataSource createDataSource() {
        final String localhost = "5432";
        final String dbName = "bank17";
        final String userName = "postgres";
        final String password = "corbandallas21";


        final String url =  "jdbc:postgresql://localhost:" + localhost + "/" + dbName + "?user=" + userName + "&password=" + password;


        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(url);
        return dataSource;
    }



    public static Connection getConnection() throws SQLException {

        return createDataSource().getConnection();
    }
}
