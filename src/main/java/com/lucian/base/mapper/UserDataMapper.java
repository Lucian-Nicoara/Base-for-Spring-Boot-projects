package com.lucian.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lucian.base.model.UserData;
import com.lucian.base.model.UserRole;

@Mapper
public interface UserDataMapper {
	
	@Select ("select * from user_data")
	List<UserData> selectAll();
	
	@Select ("select * from user_data where id = #{id}")
	UserData getById(String id);
	
	@Select ("select * from user_data where username = #{username}")
	UserData getByUsername(String username);
	
	@Select ("select * from user_roles where userId = #{id}")
	List<UserRole> getAuthoritiesByUserId(int id);
}
