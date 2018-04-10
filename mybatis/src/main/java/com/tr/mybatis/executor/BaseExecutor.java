package com.tr.mybatis.executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.tr.mybatis.session.Configuration;

public abstract class BaseExecutor implements Executor{
	
	protected Configuration configuration;
	
	public BaseExecutor(Configuration configuration) {
		this.configuration = configuration;
	}

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
	
	protected void closeStatement(Statement statement) {
	    if (statement != null) {
	      try {
	        statement.close();
	      } catch (SQLException e) {
	        // ignore
	      }
	    }
	  }
}
