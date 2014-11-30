package com.sook.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class JDBCUtil {
	private static JDBCUtil singletonObject;
	private Connection conn;
	private JDBCUtil() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connect");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail connect");
		}
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/mindmap_threestorm";
			String userId = "root";
			String userPass = "0000";

			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection
			System.out.println("getConnection Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public static synchronized JDBCUtil getInstance() {
		if ( singletonObject == null ) {
			singletonObject = new JDBCUtil();
		}
		return singletonObject;
	}
}
