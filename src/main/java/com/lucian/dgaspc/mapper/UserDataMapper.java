package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lucian.dgaspc.model.UserData;
import com.lucian.dgaspc.model.UserRole;

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
	
	@Select ("select id, nume, prenume, idCompartiment from user_data")
	List<UserData> getPersoane();
	
	@Select ("select id, nume, prenume, idCompartiment from user_data where id = #{id}")
	UserData getPersoanaById(String id);
}