package com.prueba.converters;

import javax.faces.component.UIComponent;
import com.prueba.services.IProfesorService;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.beans.ProfesorBean;

/*
 * Por que pongo service y ya funciona el autowired.
 * Por que el primefaces lo coge y sabe donde esta aunque ya no tenga la anotacion de faces.
 * */
//@FacesConverter(value = "profeConverter", forClass = com.prueba.beans.ProfesorBean.class)
@Service
public class ProfeConverter implements Converter {

	@Autowired
	private IProfesorService profesorservice;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		
		if (!value.equals("")) {

			ProfesorBean profesorbean = profesorservice.getProfesorPorId(Integer.parseInt(value));

			return profesorbean;
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
