package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lucian.dgaspc.model.UserData;


@Mapper
public interface AdminUtilizatoriMapper {
	List<UserData> getUtilizatori();
	UserData getUtilizatorByUsername(@Param("username") String username);
	void postUtilizator(@Param("utilizator") UserData utilizator);
}