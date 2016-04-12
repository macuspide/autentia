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
import com.prueba.services.IProfesorService;

public class ProfesorFacesTest {

	ProfesorFaces sut;
	IProfesorService profesorserviceMock;
	
	private static final int ID_PROFESOR = 1;
	
	@Before
	public void init(){
		this.profesorserviceMock=mock(IProfesorService.class);
		this.sut = new ProfesorFaces(profesorserviceMock);
	}
	
	@Test
	public void shouldCallServiceGetAllWhenCallControllerInit() {

		when(profesorserviceMock.getAll()).thenReturn(mock(List.class));
		sut.setProfesorLista(mock(List.class));
		sut.init();
		
		verify(profesorserviceMock).getAll();

	}
	
	@Test
	public void shouldCallServiceInsertWhenCallControllerInsert() {

		sut.setProfesorbean(new ProfesorBean());
		sut.insert();
		
		verify(profesorserviceMock).insert(new ProfesorBean());

	}
	
	@Test
	public void shouldReturnListWhenCallControllerGetProfesorLista(){
		sut.setProfesorLista(new ArrayList());
		assertEquals((sut.getProfesorLista()).getClass(), ArrayList.class);
	}
	
	@Test
	public void shouldReturnProfesorBeanWhenCallControllerGetProfesor(){
		sut.setProfesorbean(new ProfesorBean());
		assertEquals((sut.getProfesorbean()).getClass(), ProfesorBean.class);
	}
	
	@Test
	public void shouldReturnIProfesorServiceWhenCallControllerGetProfesorService(){
		sut.setIProfesorservice(profesorserviceMock);
		assertEquals((sut.getIProfesorservice()).getClass(), profesorserviceMock.getClass());
	}
	
}
