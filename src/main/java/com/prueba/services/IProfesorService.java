package com.prueba.services;

import java.util.List;

import com.prueba.beans.ProfesorBean;

public interface IProfesorService {
	
	List<ProfesorBean> getAll();
	void insert(ProfesorBean profesorbean);	
	String selectNombre(int id_profesor);	
}
