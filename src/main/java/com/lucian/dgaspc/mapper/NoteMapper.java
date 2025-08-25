package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.lucian.dgaspc.model.Nota;

@Mapper
public interface NoteMapper {
	
	@Select ("select id, idUser, DATE_FORMAT(data, '%d.%m.%Y') as data, entitate, text from note where idEntitate = #{idEntitate} and entitate = #{entitate} order by id desc")
	List<Nota> getNote(String idEntitate, String entitate);
	
	@Insert("insert into note(idUser, idEntitate, entitate, text) values(#{idUser}, #{idEntitate}, #{entitate} , #{text})")
	Integer postNota(Nota nota);
}