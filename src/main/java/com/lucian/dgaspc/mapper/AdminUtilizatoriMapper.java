package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucian.dgaspc.model.UserData;


@Mapper
public interface AdminUtilizatoriMapper {
	List<UserData> getUtilizatori();
}