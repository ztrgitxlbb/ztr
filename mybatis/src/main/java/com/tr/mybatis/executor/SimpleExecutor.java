package com.tr.mybatis.executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.tr.user.model.User;

public class SimpleExecutor implements Executor{

	@Value("")
	private String url;
	
	@Override
	public <T> T query(String statment, String paramter) {
		try {
			Class clazz = Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root123&useSSL=true");
			PreparedStatement st = conn.prepareStatement(statment);
			st.setString(1, paramter);
			ResultSet rs = st.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString("loginName"));
				user.setPassword(rs.getString("loginPass"));
				
				list.add(user);
			}
			return (T) list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
