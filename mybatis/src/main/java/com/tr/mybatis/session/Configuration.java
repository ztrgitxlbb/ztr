package com.tr.mybatis.session;

import java.lang.reflect.Proxy;

import com.tr.mybatis.binding.MapperProxy;

public class Configuration {

	public <T> T getMapper(Class clazz, SqlSession sqlSession) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MapperProxy(sqlSession));
	}
}

