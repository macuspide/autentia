package com.prueba.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prueba.beans.CursoBean;
import com.prueba.services.ICursoService;

@Controller
@ManagedBean
@SessionScoped
public class CursoFaces implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{cursoservice}")
	@Autowired
	private ICursoService cursoservice;

	private CursoBean cursobean=new CursoBean();
	private List<CursoBean> cursosLista;

	
	public List<CursoBean> getCursosLista() {
		return cursosLista;
	}

	public ICursoService getCursoservice() {
		return cursoservice;
	}

	public void setICursoservice(ICursoService cursoservice) {
		this.cursoservice = cursoservice;
	}

	public CursoBean getCursobean() {
		return cursobean;
	}

	public void setCursobean(CursoBean cursobean) {
		this.cursobean = cursobean;
	}

	public String selectTitulo() {
		String titulo = cursoservice.selectTitulo(20);

		return titulo;
	}

	public void insert() {
		this.cursoservice.insert(cursobean);
	}

	@PostConstruct
	public void init() {
		cursosLista = cursoservice.getAll();
	}

	public List<CursoBean> getAll() {
		
		return cursosLista;
	}
	
	

}
