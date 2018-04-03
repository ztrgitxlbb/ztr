package com.tr.mybatis.executor;

/**
 * sqlsession通过executor执行与数据库交互的动作
 */
public interface Executor {

	public <T> T query(String statment, String paramter);
	
}

