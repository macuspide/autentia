package com.prueba.beans;

import java.io.Serializable;

public class CursoBean implements Serializable {
	
	private static final long serialVersionUID = 6321792448424424931L;
	
	private int id_curso;
	private String titulo;
	private int id_nivel;
	private int horas;
	private boolean activo;
	private int id_profesor;
	
	public CursoBean(int id_curso, String titulo, int id_nivel, int horas, boolean activo, int id_profesor) {
		this.id_curso = id_curso;
		this.titulo = titulo;
		this.id_nivel = id_nivel;
		this.horas = horas;
		this.activo = activo;
		this.id_profesor = id_profesor;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setId_nivel(int id_nivel) {
		this.id_nivel = id_nivel;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public int getId_curso() {
		return id_curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId_nivel() {
		return id_nivel;
	}

	public int getHoras() {
		return horas;
	}

	public boolean isActivo() {
		return activo;
	}

	public int getId_profesor() {
		return id_profesor;
	}
	
	
}
