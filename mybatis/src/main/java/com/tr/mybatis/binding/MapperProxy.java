package com.tr.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.ibatis.annotations.Select;

import com.tr.mybatis.session.SqlSession;


public class MapperProxy implements InvocationHandler{
	private SqlSession sqlSession;
	
	public MapperProxy(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		if(proxy.getClass().equals(method.getDeclaringClass())){
//			return method.invoke(proxy, args);
//		}
		String statment = "";
		if(method.getDeclaredAnnotations()[0] instanceof Select){
			Select s = (Select) method.getDeclaredAnnotations()[0];
			statment = s.value()[0];
		}
		String paramter = args[0].toString();
		
		
		return sqlSession.selectOne(statment, paramter, method.getReturnType());
	}
	

}
