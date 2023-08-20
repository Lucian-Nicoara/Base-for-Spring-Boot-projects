package com.lucian.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lucian.base.model.UserData;

@Mapper
public interface UserDataMapper {
	
	@Select ("select * from user_data")
	List<UserData> selectAll();
}
