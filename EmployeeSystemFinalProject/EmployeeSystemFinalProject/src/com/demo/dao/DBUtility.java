package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static Connection getConnection()throws ClassNotFoundException,SQLException
	{
        Connection con = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##hr", "hr");
        System.out.println("Connected to the database");
        return con;
    }
}

