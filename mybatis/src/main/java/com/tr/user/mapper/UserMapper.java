package com.tr.user.mapper;

import com.tr.mybatis.annotations.Insert;
import com.tr.mybatis.annotations.Mapper;
import com.tr.mybatis.annotations.Param;
import com.tr.mybatis.annotations.Select;
import com.tr.user.model.User;

@Mapper
public interface UserMapper {

	@Select("SELECT LOGINNAME, LOGINPASS FROM T_USER WHERE LOGINNAME = ?")
//	@Select("SELECT LOGINNAME, LOGINPASS FROM T_USER WHERE LOGINNAME = #{loginName}")
	User findUser(@Param("loginName") String loginName);
	
	@Insert("INSERT INTO T_USER(LOGINNAME, LOGINPASS) VALUES(?,?)")
	User addUser(@Param("loginName") String loginName, @Param("loginPass") String loginPass);

}
