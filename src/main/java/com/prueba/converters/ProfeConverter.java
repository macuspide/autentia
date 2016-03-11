package com.prueba.converters;

import javax.faces.component.UIComponent;
import com.prueba.services.IProfesorService;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.beans.ProfesorBean;

@FacesConverter(value = "profeConverter", forClass = com.prueba.beans.ProfesorBean.class)
public class ProfeConverter implements Converter {

	@Autowired
	private IProfesorService profesorservice;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		
		if (value != "") {
			//ProfesorBean profesorbean = new ProfesorBean();
			//ProfesorBean profesorbean = profesorservice.getProfesorPorId(Integer.parseInt(value));

			return new ProfesorBean(3,"Jose Pepe");
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			ProfesorBean profesorbean = (ProfesorBean) value;
			String profestStr = String.valueOf(profesorbean.getId_profesor());
			return profestStr;

		}
		return null;

	}
}
