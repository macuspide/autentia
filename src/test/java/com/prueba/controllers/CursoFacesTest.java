package com.prueba.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.prueba.beans.ProfesorBean;
import com.prueba.services.ICursoService;
import com.prueba.services.INivelService;
import com.prueba.services.IProfesorService;

public class CursoFacesTest {

	CursoFaces sut;
	ICursoService cursoserviceMock;
	IProfesorService profesorserviceMock;
	INivelService nivelserviceMock;
	
	private static final int ID_PROFESOR = 1;
	
	@Before
	public void init(){
		this.cursoserviceMock=mock(ICursoService.class);
		this.profesorserviceMock=mock(IProfesorService.class);
		this.nivelserviceMock=mock(INivelService.class);
		this.sut = new CursoFaces(cursoserviceMock,profesorserviceMock,nivelserviceMock);
	}
	
	@Test
	public void shouldCallServiceGetAllWhenCallControllerInit() {

		when(cursoserviceMock.getAllActivos()).thenReturn(mock(List.class));
		when(profesorserviceMock.getAll()).thenReturn(mock(List.class));
		when(nivelserviceMock.getAllNiveles()).thenReturn(mock(List.class));

		sut.init();
		
		verify(cursoserviceMock).getAllActivos();
		verify(profesorserviceMock).getAll();
		verify(nivelserviceMock).getAllNiveles();

	}
	
	
	
}
