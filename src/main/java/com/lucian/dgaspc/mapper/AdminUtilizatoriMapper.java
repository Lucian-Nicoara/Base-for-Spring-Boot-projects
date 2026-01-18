package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lucian.dgaspc.model.UserData;
import com.lucian.dgaspc.model.UserRole;


@Mapper
public interface AdminUtilizatoriMapper {
	List<UserData> getUtilizatori();
	UserData getUtilizatorByUsername(@Param("username") String username);
	void postUtilizator(@Param("utilizator") UserData utilizator);
	void putUtilizator(@Param("utilizator") UserData utilizator);
	UserRole getRolByUserIdAndRol(@Param("idUser") int idUser, @Param("rol") String rol);
	void postRolUtilizator(@Param("idUser") int idUser, @Param("rol") String rol);
	void deleteRolUtilizator(@Param("idUser") int idUser, @Param("rol") String rol);
	void deleteAllByUserId(@Param("idUser") int idUser);
}