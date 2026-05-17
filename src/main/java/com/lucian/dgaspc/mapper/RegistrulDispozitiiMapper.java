package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lucian.dgaspc.model.Dispozitie;


@Mapper
public interface RegistrulDispozitiiMapper {
	
	@Select("select id, nrDispozitie, DATE_FORMAT(dataDispozitie, '%d.%m.%Y') as dataDispozitie, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, numeFisier, stadiu, (select count(*) from note where idEntitate = r.id and entitate = 'registrulDispozitii') as totalNote from registrul_dispozitii r where sters is null order by id desc")
	List<Dispozitie> getDispozitii();
	
	@Select("select id, nrDispozitie, DATE_FORMAT(dataDispozitie, '%d.%m.%Y') as dataDispozitie, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, numeFisier, stadiu from registrul_dispozitii where id = #{id} and sters is null")
	Dispozitie getDispozitieById(String id);
	
	@Insert("insert into registrul_dispozitii(nrDispozitie, dataDispozitie, emitent, dataComunicarii, fisier, numeFisier, stadiu)"
			+ "values(#{nrDispozitie}, STR_TO_DATE(#{dataDispozitie}, '%d.%m.%Y'), #{emitent} , STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), null, null, #{stadiu})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	Integer postDispozitie(Dispozitie dispozitie);
	
	@Update("update registrul_dispozitii set nrDispozitie = #{nrDispozitie}, dataDispozitie = STR_TO_DATE(#{dataDispozitie}, '%d.%m.%Y'), emitent = #{emitent}, dataComunicarii = STR_TO_DATE(#{dataComunicarii}, '%d.%m.%Y'), stadiu = #{stadiu} where id = #{id}")
	void putDispozitie(Dispozitie dispozitie);
	
	@Update("update registrul_dispozitii set numeFisier = #{numeFisier}, fisier = #{continutFisier} where id = #{idDispozitie}")
	void incarcaFisier(String idDispozitie, String numeFisier, byte[] continutFisier);
	
	@Select("select id, nrDispozitie, DATE_FORMAT(dataDispozitie, '%d.%m.%Y') as dataDispozitie, emitent, DATE_FORMAT(dataComunicarii, '%d.%m.%Y') as dataComunicarii, numeFisier, fisier, stadiu from registrul_dispozitii where id = #{id} and sters is null ")
	Dispozitie getDispozitieCuFisier(String id);
	
	/*
	 * @Delete("delete from registrul_dispozitii where id = #{id}")
	 * void stergeDispozitie(String id);
	 */
	@Update("update registrul_dispozitii set sters = 'DA' where id = #{idDispozitie}")
	void stergeDispozitie(String id);
}
