package com.lucian.dgaspc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.lucian.dgaspc.model.Nota;

@Mapper
public interface NoteMapper {
	
	@Select ("select id, idUser, DATE_FORMAT(data, '%d.%m.%Y') as data, entitate, text from note where entitate = #{entitate} order by id desc")
	List<Nota> getNote(String entitate);
}
