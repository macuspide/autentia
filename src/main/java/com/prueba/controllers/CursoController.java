package com.prueba.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prueba.beans.CursoBean;
import com.prueba.services.CursoService;

@Controller
public class CursoController {
	@Autowired
	CursoService cursoservice;

	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public void prueba(Locale locale, Model model) {
		String variable = "Soy una variable";
		model.addAttribute("variable", variable);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public void listar(Locale locale, Model model) {
		List<CursoBean> resultado= cursoservice.getAll();
		CursoBean bn=resultado.get(1);
		model.addAttribute("variable", bn.getTitulo());
	}
	
	@RequestMapping(value = "/titulo", method = RequestMethod.GET)
	public void titulo(Locale locale, Model model) {
		String resultado= cursoservice.selectTitulo(16);
		model.addAttribute("variable", resultado);
	}
}
