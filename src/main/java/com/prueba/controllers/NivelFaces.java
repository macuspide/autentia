package com.prueba.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prueba.beans.NivelBean;
import com.prueba.services.INivelService;

@Controller
@ManagedBean
@SessionScoped
public class NivelFaces implements Serializable{

	private static final long serialVersionUID = -8646444419515398178L;

	@ManagedProperty("#{nivelservice}")
	@Autowired
	private INivelService nivelservice;
	
	private NivelBean nivelbeanseleccionado;
	private List<NivelBean> nivelesLista;
	
	
	
	public INivelService getNivelservice() {
		return nivelservice;
	}

	public void setNivelservice(INivelService nivelservice) {
		this.nivelservice = nivelservice;
	}

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

	public NivelBean getNivel(int id_nivel){
		nivelbeanseleccionado = nivelservice.getNivel(id_nivel);
		return nivelbeanseleccionado;
	}
	
	public List<NivelBean> getAllNiveles(){

		return nivelesLista;
	}
	
	@PostConstruct
	public void init() {
		nivelesLista = nivelservice.getAllNiveles();
	}

}
