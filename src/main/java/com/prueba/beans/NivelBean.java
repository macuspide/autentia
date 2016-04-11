package com.prueba.beans;

import java.io.Serializable;

public class NivelBean implements Serializable {
	int id_nivel;
	String nombre_nivel;
	
	
	public NivelBean() {
		//Constructor por defecto
	}	
	
	public NivelBean(int id_nivel, String nombre_nivel) {
		super();
		this.id_nivel = id_nivel;
		this.nombre_nivel = nombre_nivel;
	}
	public int getId_nivel() {
		return id_nivel;
	}
	public void setId_nivel(int id_nivel) {
		this.id_nivel = id_nivel;
	}
	public String getNombre_nivel() {
		return nombre_nivel;
	}
	public void setNombre_nivel(String nombre_nivel) {
		this.nombre_nivel = nombre_nivel;
	}
	
    @Override
    public String toString() {

    	return id_nivel +","+ nombre_nivel;
    }
    
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof NivelBean)) {
			return false;
		}
		NivelBean recibido = (NivelBean) object;
		if ((this.id_nivel == 0 && recibido.id_nivel != 0)
				|| (this.id_nivel != 0 && !(this.id_nivel == recibido.id_nivel))) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode(){
		return id_nivel;
	}
	
	
}
