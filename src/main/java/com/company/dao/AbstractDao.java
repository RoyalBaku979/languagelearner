package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDao {
    public Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");//JDBC - Java Database Connectivity
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/language_learner", "root", "");
        return c;
    }

}
