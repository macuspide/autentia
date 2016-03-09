package com.prueba.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.prueba.beans.NivelBean;
import com.prueba.beans.CursoBean;
import com.prueba.beans.ProfesorBean;

public interface CursoMapper {
	 
	@Select("SELECT * FROM cursos")
	@Results(value ={
        @Result(property = "id_curso", column = "id_curso", id = true),
        @Result(property = "titulo", column = "titulo"),
        @Result(property = "nivelbean", column = "id_nivel", javaType=NivelBean.class, one=@One(select="com.prueba.mappers.NivelMapper.getNivel")),
        @Result(property = "horas", column = "horas"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "profesorbean", column = "id_profesor", javaType=ProfesorBean.class, one=@One(select="getProfesorPorId"))
        //@Result(property = "id_profesor", column = "id_profesor", javaType=ProfesorBean.class, one=@One(select="com.prueba.services.IProfesorService.getProfesorPorId"))
      })
	@Options(useCache=true)
	List<CursoBean> getAll();

	@Insert("Insert into cursos (titulo, id_nivel, horas, activo, id_profesor) values (#{titulo},#{id_nivel},#{horas},#{activo},#{id_profesor})")
	@Options(useGeneratedKeys = true, keyProperty = "id_curso", flushCache=true, keyColumn = "id_curso")
	void insert(CursoBean cursobean);

	@Select("SELECT titulo FROM cursos WHERE horas = #{horas}")
	String selectTitulo(int horas);
	
	@Select("SELECT id_profesor, nombre_profe FROM profesores WHERE id_profesor = #{id_profesor}")
	ProfesorBean getProfesorPorId(int id_profesor);
	

}
