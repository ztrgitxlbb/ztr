package com.tr.mybatis.session;

import java.util.List;

import com.tr.mybatis.executor.Executor;

/**
 * 用户通过sqlsession与数据库交互
 * 
 * @author 27387
 *
 */

public class SqlSession {
	/**
	 * sqlsession通过config获取与数据库交互的配置信息
	 */
	private Configuration configuration;
	
	/**
	 * sqlsession通过executor执行与数据库交互的动作
	 */
	private Executor executor;
	public SqlSession(Configuration configuration, Executor executor) {
		this.configuration = configuration;
		this.executor = executor;
	}
	
	public <T> T getMapper(Class<T> clazz){
		return configuration.getMapper(clazz, this);
	}
	
	public <T> T selectOne(String statment, String paramter, Class<T> clazz){
		T t = executor.query(statment, paramter);
		if(t instanceof List && t != null){
			if(((List) t).isEmpty()){
				return null;
			}
			return (T) ((List) t).get(0);
		}
		return t;
	}
}

