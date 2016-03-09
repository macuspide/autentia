package com.prueba.beans;

import java.io.Serializable;

public class CursoBean implements Serializable {
	
	private static final long serialVersionUID = 6321792448424424931L;
	
	private int id_curso;
	private String titulo;
	private NivelBean nivelbean;
	private int horas;
	private boolean activo;
	private ProfesorBean profesorbean;
	
	public CursoBean(){
		
	}
	
	public CursoBean(int id_curso, String titulo, NivelBean nivelbean, int horas, boolean activo, ProfesorBean profesorbean) {
		this.id_curso = id_curso;
		this.titulo = titulo;
		this.nivelbean = nivelbean;
		this.horas = horas;
		this.activo = activo;
		this.profesorbean = profesorbean;
	}

	public void setNivelbean(NivelBean nivelbean) {
		this.nivelbean = nivelbean;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setProfesorBean(ProfesorBean profesorbean) {
		this.profesorbean = profesorbean;
	}

	public NivelBean getNivelbean() {
		return nivelbean;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId_curso() {
		return id_curso;
	}

	public int getHoras() {
		return horas;
	}

	public boolean isActivo() {
		return activo;
	}

	public ProfesorBean getProfesorBean() {
		return this.profesorbean;
	}
	
	
}
