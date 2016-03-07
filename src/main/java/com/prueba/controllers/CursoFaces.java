package com.prueba.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.prueba.beans.CursoBean;
import com.prueba.services.CursoService;

@ManagedBean
@SessionScoped
public class CursoFaces {
	
	@ManagedProperty("#{cursoservice}")
	private CursoService cursoservice;
	
	private CursoBean cursobean = new CursoBean();

	public CursoService getCursoservice() {
		return cursoservice;
	}

	public void setCursoservice(CursoService cursoservice) {
		this.cursoservice = cursoservice;
	}

	public CursoBean getCursobean() {
		return cursobean;
	}

	public void setCursobean(CursoBean cursobean) {
		this.cursobean = cursobean;
	}

	public String selectTitulo(){
		String titulo=cursoservice.selectTitulo(20);
		
		return titulo;
	}
	public void insert(){
		cursoservice.insert(cursobean);
	}

}
