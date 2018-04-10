package com.tr.mybatis.session;

import java.lang.reflect.Proxy;

import com.tr.mybatis.binding.MapperProxy;
import com.tr.mybatis.executor.handler.ParameterHandler;
import com.tr.mybatis.executor.handler.ResultSetHandler;
import com.tr.mybatis.executor.handler.RoutingStatementHandler;
import com.tr.mybatis.executor.handler.StatementHandler;

public class Configuration {

	public <T> T getMapper(Class clazz, SqlSession sqlSession) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MapperProxy(sqlSession));
	}

	public ParameterHandler newParameterHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSetHandler newResultSetHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public StatementHandler newStatementHandler(String statment, String paramter) {
		StatementHandler handler = new RoutingStatementHandler(this, statment, paramter);
		return handler;
	}
}

