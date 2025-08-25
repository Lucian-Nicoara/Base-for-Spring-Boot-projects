package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lucian.dgaspc.model.HotarareCJC;


@Mapper
public interface RegistrulHcjcMapper {
	
	@Select ("select id, nrHotarare, DATE_FORMAT(dataHotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, idCompartiment, compartimentulAdresat, idPersoanaPrimire, persoanaPrimire, DATE_FORMAT(dataPrimirii, '%d.%m.%Y') as dataPrimirii, numeFisier, stadiu from registrul_hcjc order by id desc")
	List<HotarareCJC> getHotarariCJC();
	
	@Select ("select id, nrHotarare, DATE_FORMAT(dataHotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, idCompartiment, , idPersoanaPrimire, persoanaPrimire, DATE_FORMAT(dataPrimirii, '%d.%m.%Y') as dataPrimirii, numeFisier, stadiu from registrul_hcjc where id = #{id}")
	HotarareCJC getHotarareCJCById(String id);
	
	@Insert("insert into registrul_hcjc(nrHotarare, dataHotarare, emitent, dataComunicarii, idCompartiment, compartimentulAdresat, idPersoanaPrimire, persoanaPrimire, dataPrimirii, fisier, numeFisier, stadiu)"
			+ "values(#{nrHotarare}, STR_TO_DATE(#{dataHotarare}, '%d.%m.%Y'), #{emitent} , STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), #{idCompartiment}, #{compartimentulAdresat}, #{idPersoanaPrimire}, #{persoanaPrimire}, STR_TO_DATE(#{dataPrimirii}, '%d.%m.%Y'), null, null, #{stadiu})")
	Integer postHotarareCJC(HotarareCJC hotarareCJC);
	
	@Update("update registrul_hcjc set nrHotarare = #{nrHotarare}, dataHotarare = STR_TO_DATE(#{dataHotarare}, '%d.%m.%Y'), emitent = #{emitent}, dataComunicarii = STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), idCompartiment = #{idCompartiment}, compartimentulAdresat = #{compartimentulAdresat}, idPersoanaPrimire = #{idPersoanaPrimire}, persoanaPrimire = #{persoanaPrimire}, dataPrimirii = STR_TO_DATE(#{dataPrimirii}, '%d.%m.%Y'), stadiu = #{stadiu} where id = #{id}")
	void putHotarareCJC(HotarareCJC hotarareCJC);
	
	@Update("update registrul_hcjc set numeFisier = #{numeFisier}, fisier = #{continutFisier} where id = #{idHotarare}")
	void incarcaFisier(String idHotarare, String numeFisier, byte[] continutFisier);
	
	@Select ("select id, nrHotarare, DATE_FORMAT(dataHotarare, '%d.%m.%Y') as dataHotarare, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, idCompartiment, compartimentulAdresat, idPersoanaPrimire, persoanaPrimire, DATE_FORMAT(dataPrimirii, '%d.%m.%Y') as dataPrimirii, numeFisier, fisier, stadiu from registrul_hcjc where id = #{id}")
	HotarareCJC getHotarareCuFisier(String id);
}
