package com.tr.user.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tr.mybatis.executor.SimpleExecutor;
import com.tr.mybatis.session.Configuration;
import com.tr.mybatis.session.SqlSession;
import com.tr.user.mapper.HelloMapper;
import com.tr.user.model.User;

@Controller
public class HelloController {
//	
	@Autowired
	private HelloMapper helloMapper;

	@RequestMapping("/hello")
	public String hello(String loginName, ModelMap map){
		if(!StringUtils.isEmpty(loginName)){
//			SqlSession ss = new SqlSession(new Configuration(), new SimpleExecutor());	
//			User user = ss.getMapper(UserMapper.class).findUser(loginName);
			
			User user = helloMapper.findUser(loginName);
			map.put("user", user);
		}
		return "index";
	}
	
}
