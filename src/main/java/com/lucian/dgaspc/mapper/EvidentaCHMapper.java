package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.lucian.dgaspc.model.CopilHandicap;


@Mapper
public interface EvidentaCHMapper {
	//@Select("select id, DATE_FORMAT(dataComisie, '%d.%m.%Y') as dataComisie, nume, prenume, sex, DATE_FORMAT(dataNasterii, '%d.%m.%Y') as dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer, TIMESTAMPDIFF(YEAR, dataNasterii, CURDATE()) AS varsta, (select count(*) from note where idEntitate = ev.id and entitate = 'evidentaCH') as totalNote from evidenta_ch ev where TIMESTAMPDIFF(YEAR, dataNasterii, CURDATE()) BETWEEN #{filtruVarstaStart} AND #{filtruVarstaEnd} and ev.dataComisie BETWEEN STR_TO_DATE(#{filtruDataComisieStart}, '%d.%m.%Y') AND STR_TO_DATE(#{filtruDataComisieEnd}, '%d.%m.%Y') and sters is null order by ev.dataComisie desc")
	List<CopilHandicap> getEvidentaCH(@Param("filtruDataComisieStart") String filtruDataComisieStart, @Param("filtruDataComisieEnd") String filtruDataComisieEnd, @Param("filtruVarstaStart") String filtruVarstaStart, @Param("filtruVarstaEnd") String filtruVarstaEnd);
	
	@Select("select id, DATE_FORMAT(dataComisie, '%d.%m.%Y') as dataComisie, nume, prenume, sex, DATE_FORMAT(dataNasterii, '%d.%m.%Y') as dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer, TIMESTAMPDIFF(YEAR, dataNasterii, CURDATE()) AS varsta, (select count(*) from note where idEntitate = ev.id and entitate = 'evidentaCH') as totalNote from evidenta_ch where id = #{id} and sters is null")
	CopilHandicap getCopilHandicapById(String id);
	
	@Select("select id, DATE_FORMAT(dataComisie, '%d.%m.%Y') as dataComisie, nume, prenume, sex, DATE_FORMAT(dataNasterii, '%d.%m.%Y') as dataNasterii, cnp, domiciliu, diagnostic, codCim, tipHandicap, gradHandicap, insotitor, scolarizat, cazNou, locul, categoriiDeAfectiune, valabilitateCertificat, statusTransfer, infoTransfer, TIMESTAMPDIFF(YEAR, dataNasterii, CURDATE()) AS varsta from evidenta_ch ev where cnp = #{cnp} and sters is null order by ev.dataComisie desc limit 1")
	CopilHandicap getCopilByCNP(String cnp);
	
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