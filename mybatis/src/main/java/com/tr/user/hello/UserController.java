package com.tr.user.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tr.mybatis.executor.SimpleExecutor;
import com.tr.mybatis.session.Configuration;
import com.tr.mybatis.session.SqlSession;
import com.tr.user.mapper.UserMapper;
import com.tr.user.model.User;

@Controller
public class UserController {
//	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user")
	public String hello(String loginName, ModelMap map){
		if(!StringUtils.isEmpty(loginName)){
			SqlSession ss = new SqlSession(new Configuration(), new SimpleExecutor());	
//			User user = ss.getMapper(UserMapper.class).findUser(loginName);
			
//			User user = userMapper.findUser(loginName);
//			map.put("user", user);
		}
		return "index";
	}
	
	@RequestMapping("/add")
	public String addUser(String loginName, String password, ModelMap map){
		if(!StringUtils.isEmpty(loginName)){
			SqlSession ss = new SqlSession(new Configuration(), new SimpleExecutor());	
			
	//		User user = userMapper.findUser();
//			User user = ss.getMapper(UserMapper.class).findUser(loginName);
//			map.put("user", user);
		}
		return "index";
	}
}
