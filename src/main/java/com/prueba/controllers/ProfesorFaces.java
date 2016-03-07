package com.prueba.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prueba.beans.ProfesorBean;
import com.prueba.services.IProfesorService;
import com.prueba.services.ProfesorService;

@Controller
@ManagedBean
@SessionScoped
public class ProfesorFaces {
	
	@ManagedProperty("#{profesorservice}")
	@Autowired
	private IProfesorService profesorservice;
	
	private ProfesorBean profesorbean = new ProfesorBean();

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
	
	public String selectNombre(){
		String nombre_profe=profesorservice.selectNombre(1);
		
		return nombre_profe;
	}
	public String insert(){
		this.profesorservice.insert(profesorbean);
		/*
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("El profesor "+this.profesorbean.getNombre_profe()+" se ha creado correctamente"));
        */
        return "";
	}

}
