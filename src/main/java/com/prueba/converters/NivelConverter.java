package com.prueba.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.beans.NivelBean;
import com.prueba.beans.ProfesorBean;
import com.prueba.services.INivelService;
import com.prueba.services.IProfesorService;

@Service
public class NivelConverter implements Converter {
	@Autowired
	private INivelService nivelservice;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		
		if (value != "") {

			NivelBean nivelbean = nivelservice.getNivelPorId(Integer.parseInt(value));

			return nivelbean;
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			NivelBean nivelbean = (NivelBean) value;
			String nivelStr = String.valueOf(nivelbean.getId_nivel());
			return nivelStr;

		}
		return null;

	}
} 
