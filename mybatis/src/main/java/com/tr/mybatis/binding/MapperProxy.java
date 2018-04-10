package com.tr.mybatis.binding;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.ibatis.mapping.SqlCommandType;

import com.tr.mybatis.annotations.Insert;
import com.tr.mybatis.annotations.Select;
import com.tr.mybatis.session.SqlSession;


public class MapperProxy implements InvocationHandler{
	private SqlSession sqlSession;
	
	public MapperProxy(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		SqlCommand command = new SqlCommand(method);
		
		String paramter = args[0].toString();
		
		return sqlSession.selectOne(command.getSql(), paramter, method.getReturnType());
	}
	

	public static class SqlCommand{
		private final String name;
		private String sql;
	    private SqlCommandType type;
		public SqlCommand(Method method) {
			this.name = method.getDeclaringClass().getName();
			
			init(method.getDeclaredAnnotations());
		}
		private void init(Annotation[] annotations){
			for(Annotation annotation : annotations){
				if(annotation instanceof Select){
					Select s = (Select) annotation;
					sql = s.value()[0];
					type = SqlCommandType.SELECT;
				}
				if(annotation instanceof Insert){
					Insert s = (Insert) annotation;
					sql = s.value()[0];
					type = SqlCommandType.INSERT;
				}
			}
//			sql = "";
//			type = SqlCommandType.UNKNOWN;
		}
		
		public String getName() {
			return name;
		}
		public String getSql() {
			return sql;
		}
		public SqlCommandType getType() {
			return type;
		}
	    
	    
	}
}
