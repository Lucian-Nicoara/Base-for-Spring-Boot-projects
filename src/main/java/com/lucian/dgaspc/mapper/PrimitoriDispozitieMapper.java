package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lucian.dgaspc.model.PrimitorDispozitie;

@Mapper
public interface PrimitoriDispozitieMapper {
	List<PrimitorDispozitie> getPrimitoriByIdDispozitie(@Param("idDispozitie") Integer idDispozitie);
	void postPrimitorDispozitie(@Param("primitorDispozitie") PrimitorDispozitie primitorDispozitie);
	void deletePrimitorDispozitieById(@Param("id") Integer id);
	void deleteAllPrimitoriByIdDispozitie(@Param("idDispozitie") Integer idDispozitie);
}