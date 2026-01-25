package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lucian.dgaspc.model.PrimitorHCJC;

@Mapper
public interface PrimitoriHCJCMapper {
	List<PrimitorHCJC> getPrimitoriByIdHCJC(@Param("idHotarareHCJC") Integer idHotarareHCJC);
	void postPrimitorHCJC(@Param("primitorHCJC") PrimitorHCJC primitorHCJC);
	void deletePrimitorHCJCById(@Param("id") Integer id);
	void deleteAllPrimitoriByIdHCJC(@Param("idHotarareHCJC") Integer idHotarareHCJC);
}