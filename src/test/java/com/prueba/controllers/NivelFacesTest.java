package com.prueba.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.prueba.beans.NivelBean;
import com.prueba.beans.ProfesorBean;
import com.prueba.mappers.NivelMapper;
import com.prueba.services.INivelService;

public class NivelFacesTest {

		NivelFaces sut;
		
		INivelService nivelserviceMock;
		
		private static final int ID_NIVEL = 1;
		
		@Before
		public void init(){
			
			this.nivelserviceMock = mock(INivelService.class);
			
			sut = new NivelFaces(nivelserviceMock);
		}
		
		@Test
		public void shouldReturnINivelServiceWhenCallControllerGetNivelService(){
			assertEquals((sut.getNivelservice()).getClass(), nivelserviceMock.getClass());
		}
		
		@Test
		public void shouldCallServiceGetNivelWhenCallControllerGetNivel(){
			
			when(nivelserviceMock.getNivel(ID_NIVEL)).thenReturn(new NivelBean());
			
			sut.getNivel(ID_NIVEL);
			
			verify(nivelserviceMock).getNivel(ID_NIVEL);
			
			verify(nivelserviceMock, Mockito.never()).getAllNiveles();
		}
		
		@Test
		public void shouldCallServiceGetAllNivelesWhenCallControllerGetAllNiveles(){
			
			sut.setNivelesLista(new ArrayList());
			assertEquals((sut.getAllNiveles()).getClass(), ArrayList.class);
			assertEquals((sut.getNivelesLista()).getClass(), ArrayList.class);
		}
		
		@Test
		public void shouldReturnNivelBeanWhenCallControllerGetNivelBean(){
			sut.setNivelbean(new NivelBean());
			assertEquals((sut.getNivelbean()).getClass(), NivelBean.class);
		}
		
		@Test
		public void shouldCallServiceGetAllNivelesWhenCallControllerInit() {

			when(nivelserviceMock.getAllNiveles()).thenReturn(mock(List.class));
			
			sut.init();
			
			verify(nivelserviceMock).getAllNiveles();

		}
		
}
