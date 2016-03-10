package com.prueba.beans;

import java.io.Serializable;

public class ProfesorBean implements Serializable {

	private static final long serialVersionUID = 6321792448424424931L;

	private int id_profesor;
	private String nombre_profe;

	public ProfesorBean() {
	}

	public ProfesorBean(int id_profesor, String nombre_profe) {
		super();
		this.id_profesor=id_profesor;
		this.nombre_profe = nombre_profe;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public String getNombre_profe() {
		return nombre_profe;
	}

	public void setNombre_profe(String nombre_profe) {
		this.nombre_profe = nombre_profe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return String.format("ProfesorBean", id_profesor, nombre_profe);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ProfesorBean)) {
			return false;
		}
		ProfesorBean recibido = (ProfesorBean) object;
		if ((this.id_profesor == 0 && recibido.id_profesor != 0)
				|| (this.id_profesor != 0 && !(this.id_profesor == recibido.id_profesor))) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode(){
	    return (int) id_profesor;
	  }

}
