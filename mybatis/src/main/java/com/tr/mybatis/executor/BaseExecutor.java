package com.tr.mybatis.executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseExecutor implements Executor{
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class clazz = Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root123&useSSL=true");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
