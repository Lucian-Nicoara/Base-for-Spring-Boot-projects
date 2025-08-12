package com.lucian.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lucian.base.model.HotarareCJC;


@Mapper
public interface RegistrulHcjcMapper {
	
	@Select ("select nr_hotarare as nrHotarare, DATE_FORMAT(data_hotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(data_comunicarii, '%d.%m.%Y') as dataComunicarii, compartimentul_adresat as compartimentulAdresat, persoana_primire as persoanaPrimire, DATE_FORMAT(data_primirii, '%d.%m.%Y') as dataPrimirii from registrul_hcjc order by id desc")
	List<HotarareCJC> getHotarariCJC();
	
	@Select ("nr_hotarare as nrHotarare, DATE_FORMAT(data_hotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(data_comunicarii, '%d.%m.%Y') as dataComunicarii, compartimentul_adresat as compartimentulAdresat, persoana_primire as persoanaPrimire, DATE_FORMAT(data_primirii, '%d.%m.%Y') as dataPrimirii from registrul_hcjc where id = #{id}")
/*	@Results({
    @Result(property = "nrHotarare", column = "nr_hotarare"),
    @Result(property = "dataHotarare", column = "data_hotarare"),
    @Result(property = "dataComunicarii", column = "data_comunicarii"),
    @Result(property = "compartimentulAdresat", column = "compartimentul_adresat"),
    @Result(property = "persoanaPrimire", column = "persoana_primire"),
    @Result(property = "dataPrimirii", column = "data_primirii")
})*/
	HotarareCJC getById(String id);
	
	@Insert("insert into registrul_hcjc(nr_hotarare, data_hotarare, emitent, data_comunicarii, compartimentul_adresat, persoana_primire, data_primirii, stadiu) "
			+ "values(#{nrHotarare}, STR_TO_DATE(#{dataHotarare}, '%d.%m.%Y'), #{emitent} , STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), #{compartimentulAdresat}, #{persoanaPrimire}, STR_TO_DATE(#{dataPrimirii}, '%d.%m.%Y'), #{stadiu})")
	Integer postHotarareCJC(HotarareCJC hotarareCJC); 
}
