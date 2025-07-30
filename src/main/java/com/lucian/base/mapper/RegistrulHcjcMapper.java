package com.lucian.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lucian.base.model.HotarareCJC;


@Mapper
public interface RegistrulHcjcMapper {
	
	@Select ("select * from registrul_hcjc")
	@Results({
        @Result(property = "nrHotarare", column = "nr_hotarare"),
        @Result(property = "dataHotarare", column = "data_hotarare"),
        @Result(property = "dataComunicarii", column = "data_comunicarii"),
        @Result(property = "compartimentulAdresat", column = "compartimentul_adresat"),
        @Result(property = "persoanaPrimire", column = "persoana_primire"),
        @Result(property = "dataPrimirii", column = "data_primirii")
    })
	List<HotarareCJC> getHotarariCJC();
	
	@Select ("select * from registrul_hcjc where id = #{id}")
	@Results({
        @Result(property = "nrHotarare", column = "nr_hotarare"),
        @Result(property = "dataHotarare", column = "data_hotarare"),
        @Result(property = "dataComunicarii", column = "data_comunicarii"),
        @Result(property = "compartimentulAdresat", column = "compartimentul_adresat"),
        @Result(property = "persoanaPrimire", column = "persoana_primire"),
        @Result(property = "dataPrimirii", column = "data_primirii")
    })
	HotarareCJC getById(String id);
	
}
