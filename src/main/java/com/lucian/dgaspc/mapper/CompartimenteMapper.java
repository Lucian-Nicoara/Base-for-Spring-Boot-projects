package com.lucian.dgaspc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lucian.dgaspc.model.Compartiment;

@Mapper
public interface CompartimenteMapper {
	
	@Select ("select id, nume from compartimente")
	List<Compartiment> getCompartimente();
	
	@Select ("select id, nume from compartimente where id = #{id}")
	Compartiment getCompartimentById(String id);
}
