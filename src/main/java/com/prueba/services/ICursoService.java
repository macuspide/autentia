package com.prueba.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.prueba.beans.CursoBean;
import com.prueba.beans.NivelBean;

public interface ICursoService {
	
	List<CursoBean> getAll();
	void insert(CursoBean curso);
	String selectTitulo(int horas);
}
