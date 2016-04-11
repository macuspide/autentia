package com.prueba.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prueba.beans.CursoBean;
import com.prueba.beans.NivelBean;
import com.prueba.beans.ProfesorBean;
import com.prueba.services.ICursoService;
import com.prueba.services.INivelService;
import com.prueba.services.IProfesorService;
import com.prueba.controllers.ProfesorFaces;

@Controller
@ManagedBean
@SessionScoped
public class CursoFaces implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{cursoservice}")
	@Autowired
	private transient ICursoService cursoservice;
	
	private CursoBean cursobean=new CursoBean();
	private List<CursoBean> cursosLista;

	@ManagedProperty("#{profesorservice}")
	@Autowired
	private transient IProfesorService profesorservice;
	
	private ProfesorBean profesorbean;
	private List<ProfesorBean> profesorLista;
	
	@ManagedProperty("#{nivelservice}")
	@Autowired
	private transient INivelService nivelservice;
	
	private transient NivelBean nivelbean;
	private transient List<NivelBean> nivelLista;

	public INivelService getNivelservice() {
		return nivelservice;
	}

	public void setNivelservice(INivelService nivelservice) {
		this.nivelservice = nivelservice;
	}

	public NivelBean getNivelbean() {
		return nivelbean;
	}

	public void setNivelbean(NivelBean nivelbean) {
		this.nivelbean = nivelbean;
	}

	public List<NivelBean> getNivelLista() {
		return nivelLista;
	}

	public void setNivelLista(List<NivelBean> nivelLista) {
		this.nivelLista = nivelLista;
	}

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
	
	public List<CursoBean> getAll() {
		
		return cursosLista;
	}

	public void insert() {
		cursobean.setNivelbean(nivelbean);
		cursobean.setId_nivel(nivelbean.getId_nivel());
		cursobean.setProfesorBean(profesorbean);
		cursobean.setId_profesor(profesorbean.getId_profesor());
		this.cursoservice.insert(cursobean);
		cursosLista.add(cursobean);
		cursobean = new CursoBean();
	}

	@PostConstruct
	public void init() {
		nivelLista = nivelservice.getAllNiveles();
		profesorLista = profesorservice.getAll();
		cursosLista = cursoservice.getAllActivos();//modificado
	}


}
