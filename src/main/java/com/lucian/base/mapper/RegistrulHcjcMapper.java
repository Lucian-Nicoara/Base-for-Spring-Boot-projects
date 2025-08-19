package com.lucian.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lucian.base.model.HotarareCJC;


@Mapper
public interface RegistrulHcjcMapper {
	
	@Select ("select id, nr_hotarare as nrHotarare, DATE_FORMAT(data_hotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(data_comunicarii, '%d.%m.%Y') as dataComunicarii, compartimentul_adresat as compartimentulAdresat, persoana_primire as persoanaPrimire, DATE_FORMAT(data_primirii, '%d.%m.%Y') as dataPrimirii, nume_fisier as numeFisier, stadiu from registrul_hcjc order by id desc")
	List<HotarareCJC> getHotarariCJC();
	
	@Select ("select id, nr_hotarare as nrHotarare, DATE_FORMAT(data_hotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(data_comunicarii, '%d.%m.%Y') as dataComunicarii, compartimentul_adresat as compartimentulAdresat, persoana_primire as persoanaPrimire, DATE_FORMAT(data_primirii, '%d.%m.%Y') as dataPrimirii, nume_fisier as numeFisier, stadiu from registrul_hcjc where id = #{id}")
	HotarareCJC getHotarareCJCById(String id);
	
	@Insert("insert into registrul_hcjc(nr_hotarare, data_hotarare, emitent, data_comunicarii, compartimentul_adresat, persoana_primire, data_primirii, fisier, nume_fisier, stadiu) "
			+ "values(#{nrHotarare}, STR_TO_DATE(#{dataHotarare}, '%d.%m.%Y'), #{emitent} , STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), #{compartimentulAdresat}, #{persoanaPrimire}, STR_TO_DATE(#{dataPrimirii}, '%d.%m.%Y'), null, null, #{stadiu})")
	Integer postHotarareCJC(HotarareCJC hotarareCJC); 
	
	@Update("update registrul_hcjc set nr_hotarare = #{nrHotarare}, data_hotarare = STR_TO_DATE(#{dataHotarare}, '%d.%m.%Y'), emitent = #{emitent} , data_comunicarii = STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), compartimentul_adresat = #{compartimentulAdresat}, persoana_primire = #{persoanaPrimire}, data_primirii = STR_TO_DATE(#{dataPrimirii}, '%d.%m.%Y'), stadiu = #{stadiu} where id = #{id}")
	void putHotarareCJC(HotarareCJC hotarareCJC);
	
	@Update("update registrul_hcjc set nume_fisier = #{numeFisier}, fisier = #{continutFisier} where id = #{idHotarare}")
	void incarcaFisier(String idHotarare, String numeFisier, byte[] continutFisier);
	
	@Select ("select id, nr_hotarare as nrHotarare, DATE_FORMAT(data_hotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(data_comunicarii, '%d.%m.%Y') as dataComunicarii, compartimentul_adresat as compartimentulAdresat, persoana_primire as persoanaPrimire, DATE_FORMAT(data_primirii, '%d.%m.%Y') as dataPrimirii, fisier, nume_fisier as numeFisier, stadiu from registrul_hcjc where id = #{id}")
	HotarareCJC getHotarareCuFisier(String id);
}
