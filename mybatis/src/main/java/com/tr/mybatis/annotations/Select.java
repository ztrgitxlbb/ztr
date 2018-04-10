package com.tr.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.mapping.SqlCommandType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select{
	//@Select("SELECT LOGINNAME, LOGINPASS FROM T_USER WHERE LOGINNAME = #{loginName}")
	//value()默认方法
	String[] value();
//	@Select(values = { "SELECT LOGINNAME, LOGINPASS FROM T_USER WHERE LOGINNAME = #{loginName}" })
//	String[] values();
	SqlCommandType type() default SqlCommandType.SELECT;
}
