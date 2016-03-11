package com.prueba.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.prueba.beans.ProfesorBean;

public interface ProfesorMapper {
	
	@Results({
		@Result(property = "id_profesor", column = "id_profesor"),
        @Result(property = "nombre_profe", column = "nombre_profe")
      })	
	
	@Select("SELECT id_profesor, nombre_profe FROM profesores")
	List<ProfesorBean> getAll();
	
	@Insert("INSERT into profesores(nombre_profe) VALUES(#{nombre_profe})")
	@Options(useGeneratedKeys = true, keyProperty = "id_profesor", flushCache = true, keyColumn = "id_profesor")
	void insert(ProfesorBean profesorbean);	
	
	@Select("SELECT nombre_profe FROM profesores WHERE id_profesor = #{id_profesor}")
	String selectNombre(int id_profesor);
	
	@Select("SELECT id_profesor, nombre_profe FROM profesores WHERE id_profesor = #{id_profesor}")
	ProfesorBean getProfesorPorId(int id_profesor);
}
