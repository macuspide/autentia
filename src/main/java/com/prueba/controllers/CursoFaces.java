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
import com.prueba.beans.ProfesorBean;
import com.prueba.services.ICursoService;
import com.prueba.services.IProfesorService;
import com.prueba.controllers.ProfesorFaces;

@Controller
@ManagedBean
@SessionScoped
public class CursoFaces implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{cursoservice}")
	@Autowired
	private ICursoService cursoservice;

	@ManagedProperty("#{profesorservice}")
	@Autowired
	private IProfesorService profesorservice;
	
	private ProfesorBean profesorbean;
	private List<ProfesorBean> profesorLista;
	
	private CursoBean cursobean=new CursoBean();
	private List<CursoBean> cursosLista;
	
	
	
	
	
	

	public List<ProfesorBean> getProfesorLista() {
		return profesorLista;
	}

	public void setProfesorLista(List<ProfesorBean> profesorLista) {
		this.profesorLista = profesorLista;
	}

	public IProfesorService getIProfesorservice() {
		return profesorservice;
	}

	public void setIProfesorservice(IProfesorService profesorservice) {
		this.profesorservice = profesorservice;
	}
	public ProfesorBean getProfesorbean() {
		return profesorbean;
	}
	public void setProfesorbean(ProfesorBean profesorbean) {
		this.profesorbean = profesorbean;
	}

	
	
	
	
	
	
	

	
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
		cursobean.setProfesorBean(profesorbean);
		cursobean.setId_profesor(profesorbean.getId_profesor());
		this.cursoservice.insert(cursobean);
	}

	@PostConstruct
	public void init() {
		profesorLista = profesorservice.getAll();
		cursosLista = cursoservice.getAll();
	}

	public List<CursoBean> getAll() {
		
		return cursosLista;
	}
	
	

}
