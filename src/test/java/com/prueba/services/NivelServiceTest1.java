package com.prueba.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.prueba.beans.NivelBean;
import com.prueba.mappers.NivelMapper;

public class NivelServiceTest1 {
	
	NivelService sut;
	
	NivelMapper nivelMapper;
	
	private static final int ID_NIVEL = 1;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Before
	public void init(){
		
		this.nivelMapper = mock(NivelMapper.class);
		
		sut = new NivelService(nivelMapper);
	}
	
	@Test
	public void shouldCallMapperGetNivelWhenCallServiceGetNivel(){
		
		when(nivelMapper.getNivel(ID_NIVEL)).thenReturn(new NivelBean());
		
		sut.getNivel(ID_NIVEL);
		
		verify(nivelMapper).getNivel(ID_NIVEL);
		
		verify(nivelMapper, Mockito.never()).getAllNiveles();
	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperReturnsNull(){
		
		when(nivelMapper.getNivel(ID_NIVEL)).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getNivel(ID_NIVEL);
	}
	
	@Test
	public void shouldCallMapperGetAllNivelesWhenCallServiceGetAllNiveles() {

		when(nivelMapper.getAllNiveles()).thenReturn(mock(List.class));
		
		sut.getAllNiveles();
		
		verify(nivelMapper).getAllNiveles();

	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperGetAllNivelesReturnsNull(){
		
		when(nivelMapper.getAllNiveles()).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getAllNiveles();
	}
}
