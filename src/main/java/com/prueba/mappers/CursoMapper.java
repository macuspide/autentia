package com.prueba.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.prueba.beans.CursoBean;

public interface CursoMapper {
	
	List<CursoBean> getAll();
	void insert(CursoBean cursobean);	
	@Select("SELECT titulo FROM cursos WHERE horas = #{horas}")
	String selectTitulo(int horas);	
	
}
