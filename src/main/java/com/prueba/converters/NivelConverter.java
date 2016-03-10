package com.prueba.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.prueba.beans.NivelBean;

@FacesConverter("nivelcon")
public class NivelConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		/*
		String[] strArr = value.split("-");
		if (strArr.length >= 2) {
			NivelBean nivelbean = new NivelBean();
			nivelbean.setId_nivel(Integer.parseInt(strArr[0]));
			nivelbean.setNombre_nivel(strArr[1]);
			
			return nivelbean;
		}
		return null;*/
		NivelBean nivelbean = new NivelBean(2, "Intermedio");
		return nivelbean;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		/*
		if (value != null ){
			ProfesorBean profesorbean = (ProfesorBean)value;
			StringBuffer strBuff = new StringBuffer(profesorbean.getId_profesor()).append("-");
			strBuff.append(profesorbean.getNombre_profe()).append("-");
			String profestStr = strBuff.toString();
			return profestStr;
		}
		return null;*/
		return "2";
	}
} 
