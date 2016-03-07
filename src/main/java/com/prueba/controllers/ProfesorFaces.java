package com.prueba.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.prueba.beans.ProfesorBean;
import com.prueba.services.ProfesorService;

@ManagedBean
@SessionScoped
public class ProfesorFaces {
	
	@ManagedProperty("#{profesorservice}")
	private ProfesorService profesorservice = new ProfesorService();
	
	private ProfesorBean profesorbean = new ProfesorBean();

	public ProfesorService getProfesorservice() {
		return profesorservice;
	}

	public void setProfesorservice(ProfesorService profesorservice) {
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
