package com.prueba.services;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.prueba.beans.CursoBean;

public interface ICursoService {
	
	List<CursoBean> getAll();
	void insert(CursoBean curso);
	String selectTitulo(int horas);
	String getNivel(int id_nivel);
}
