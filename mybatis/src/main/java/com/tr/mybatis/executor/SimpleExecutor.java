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

public class SimpleExecutor extends BaseExecutor{

	@Value("")
	private String url;
	
	@Override
	public <T> T query(String statment, String paramter) {
		try {
			
			PreparedStatement st = getConnection().prepareStatement(statment);
			st.setString(1, paramter);
			ResultSet rs = st.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setLoginName(rs.getString("loginName"));
				user.setLoginPass(rs.getString("loginPass"));
				
				list.add(user);
			}
			return (T) list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
