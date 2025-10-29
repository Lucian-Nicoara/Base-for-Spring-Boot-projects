package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.lucian.dgaspc.model.CopilHandicap;


@Mapper
public interface EvidentaCHMapper {
	
	@Select("select id, DATE_FORMAT(dataComisie, '%d.%m.%Y') as dataComisie, nume, prenume, sex, DATE_FORMAT(dataNasterii, '%d.%m.%Y') as dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer from evidenta_ch where sters is null order by id desc")
	List<CopilHandicap> getEvidentaCH();
	
	@Select("select id, DATE_FORMAT(dataComisie, '%d.%m.%Y') as dataComisie, nume, prenume, sex, DATE_FORMAT(dataNasterii, '%d.%m.%Y') as dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer from evidenta_ch where id = #{id} and sters is null order by id desc")
	CopilHandicap getCopilHandicapById(String id);
	
	@Insert("insert into evidenta_ch(dataComisie, nume, prenume, sex, dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer)"
			+ "values(STR_TO_DATE(#{dataComisie}, '%d.%m.%Y'), #{nume} , #{prenume}, #{sex}, STR_TO_DATE(#{dataNasterii}, '%d.%m.%Y'), #{cnp}, #{domiciliu}, #{diagnostic}, #{codCim}, #{tipHandicap}, #{gradHandicap}, #{insotitor}, #{scolarizat}, #{cazNou}, #{locul}, #{categoriiDeAfectiune}, #{valabilitateCertificat}, #{statusTransfer}, #{infoTransfer})")
	Integer postCopilHandicap(CopilHandicap copilHandicap);
	
	@Update("update evidenta_ch set dataComisie = STR_TO_DATE(#{dataComisie}, '%d.%m.%Y'), nume = #{nume}, prenume = #{prenume}, sex = #{sex}, dataNasterii = STR_TO_DATE(#{dataNasterii}, '%d.%m.%Y'), cnp = #{cnp}, domiciliu = #{domiciliu}, diagnostic = #{diagnostic}, codCim = #{codCim}, tipHandicap = #{tipHandicap}, gradHandicap = #{gradHandicap}, insotitor = #{insotitor}, scolarizat = #{scolarizat}, cazNou = #{cazNou}, locul = #{locul}, categoriiDeAfectiune = #{categoriiDeAfectiune}, valabilitateCertificat = #{valabilitateCertificat}, statusTransfer = #{statusTransfer}, infoTransfer = #{infoTransfer} where id = #{id}")
	void putCopilHandicap(CopilHandicap copilHandicap);
	
	/*
	 * @Delete("delete from evidenta_ch where id = #{id}") void
	 * stergeCopilHandicap(String id);
	 */
	@Update("update evidenta_ch set sters = 'DA' where id = #{id}")
	void stergeCopilHandicap(String id);
}