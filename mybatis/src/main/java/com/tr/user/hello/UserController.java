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
//	@Autowired
//	private UserMapper userMapper;

	@RequestMapping("/user")
	public String hello(String loginName, ModelMap map){
		if(!StringUtils.isEmpty(loginName)){
			Configuration configuration = new Configuration();
			SqlSession ss = new SqlSession(configuration, new SimpleExecutor(configuration));	
			User user = ss.getMapper(UserMapper.class).findUser(loginName);
			
//			User user = userMapper.findUser(loginName);
			map.put("user", user);
		}
		return "index";
	}
	
}
