package com.tr.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tr.user.model.User;

@Mapper
public interface HelloMapper {

//	@Select("SELECT * FROM T_USER WHERE LOGINNAME = ?")
	@Select("SELECT LOGINNAME, LOGINPASS FROM T_USER WHERE LOGINNAME = #{loginName}")
	User findUser(@Param("loginName") String loginName);
	
	@Insert("INSERT INTO T_USER(LOGINNAME, LOGINPASS) VALUES(?,?)")
	User addUser(@Param("loginName") String loginName, @Param("loginPass") String loginPass);

}
