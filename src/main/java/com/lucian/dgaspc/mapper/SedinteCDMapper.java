package com.lucian.dgaspc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.lucian.dgaspc.model.SedintaCD;


@Mapper
public interface SedinteCDMapper {
	
	@Select("select id, sedinta, DATE_FORMAT(dataSedinta, '%d.%m.%Y') as dataSedinta, subiect, noteDeFundamentare, hotarareAviz from consiliul_director order by id desc")
	List<SedintaCD> getSedinteCD();
	
	@Select("select id, sedinta, DATE_FORMAT(dataSedinta, '%d.%m.%Y') as dataSedinta, subiect, noteDeFundamentare, hotarareAviz from consiliul_director where id = #{id}")
	SedintaCD getSedintaCDById(String id);
	
	@Insert("insert into consiliul_director(sedinta, dataSedinta, subiect, noteDeFundamentare, hotarareAviz)"
			+ "values(#{sedinta}, STR_TO_DATE(#{dataSedinta}, '%d.%m.%Y'), #{subiect} , #{noteDeFundamentare}, #{hotarareAviz})")
	Integer postSedintaCD(SedintaCD sedintaCD);
	
	@Update("update consiliul_director set sedinta = #{sedinta}, dataSedinta = STR_TO_DATE(#{dataSedinta}, '%d.%m.%Y'), subiect = #{subiect}, noteDeFundamentare = #{noteDeFundamentare}, hotarareAviz = #{hotarareAviz} where id = #{id}")
	void putSedintaCD(SedintaCD sedintaCD);
	
	@Update("update consiliul_director set numeFisier = #{numeFisier}, fisier = #{continutFisier} where id = #{idSedintaCD}")
	void incarcaFisier(String idSedintaCD, String numeFisier, byte[] continutFisier);
	
	@Select("select id, sedinta, DATE_FORMAT(dataSedinta, '%d.%m.%Y') as dataSedinta, subiect, noteDeFundamentare, hotarareAviz, numeFisier, fisier, stadiu from consiliul_director where id = #{id}")
	SedintaCD getSedintaCDCuFisier(String id);
	
	@Delete("delete from cosiliul_director where id = #{id}")
	void stergeSedintaCD(String id);
}
