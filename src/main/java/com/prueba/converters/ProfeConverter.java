package com.prueba.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.prueba.beans.ProfesorBean;

@FacesConverter(value="profeConverter", forClass = com.prueba.beans.ProfesorBean.class)
public class ProfeConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		/*
		String[] strArr = value.split("-");
		if (strArr.length >= 2) {
			ProfesorBean profesorbean = new ProfesorBean();
			profesorbean.setId_profesor(Integer.parseInt(strArr[0]));
			profesorbean.setNombre_profe(strArr[1]);
			return profesorbean;
		}
		return null;*/
		return new ProfesorBean(3, "Jose Pepe");

	}
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		/*
		if (value != null && !(value instanceof String) ){
			ProfesorBean profesorbean = (ProfesorBean)value;
			StringBuffer strBuff = new StringBuffer(profesorbean.getId_profesor()).append("-");
			strBuff.append(profesorbean.getNombre_profe());
			String profestStr = strBuff.toString();
			return profestStr;
		}*/
		return "3";

	}
} 
