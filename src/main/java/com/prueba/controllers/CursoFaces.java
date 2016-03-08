package com.prueba.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prueba.beans.CursoBean;
import com.prueba.beans.NivelBean;
import com.prueba.services.ICursoService;

@Controller
@ManagedBean
@SessionScoped
public class CursoFaces implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{cursoservice}")
	@Autowired
	private ICursoService cursoservice;

	private CursoBean cursobeanseleccionado;
	private NivelBean nivelbeanseleccionado;
	private List<CursoBean> cursosLista;
	private List<NivelBean> nivelesLista;
	
	public NivelBean getNivelbeanseleccionado() {
		return nivelbeanseleccionado;
	}

	public void setNivelbeanseleccionado(NivelBean nivelbeanseleccionado) {
		this.nivelbeanseleccionado = nivelbeanseleccionado;
	}

	public List<NivelBean> getNivelesLista() {
		return nivelesLista;
	}

	public void setNivelesLista(List<NivelBean> nivelesLista) {
		this.nivelesLista = nivelesLista;
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
		return cursobeanseleccionado;
	}

	public void setCursobean(CursoBean cursobean) {
		this.cursobeanseleccionado = cursobean;
	}

	public String selectTitulo() {
		String titulo = cursoservice.selectTitulo(20);

		return titulo;
	}

	public void insert() {
		cursoservice.insert(cursobeanseleccionado);
	}

	@PostConstruct
	public void init() {
		cursosLista = cursoservice.getAll();
		nivelesLista = cursoservice.getAllNiveles();
	}

	public List<CursoBean> getAll() {
		
		return cursosLista;
	}
	
	

}
