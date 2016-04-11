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

import com.prueba.beans.ProfesorBean;
import com.prueba.mappers.ProfesorMapper;

public class ProfesorServiceTest1 {
	
	ProfesorService sut;
	
	ProfesorMapper profesorMapper;
	
	private static final int ID_PROFESOR = 1;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Before
	public void init(){
		
		this.profesorMapper = mock(ProfesorMapper.class);
		
		sut = new ProfesorService(profesorMapper);
	}
	
	@Test
	public void shouldCallMapperGetProfesorPorIdWhenCallServiceGetProfesorPorId(){
		
		when(profesorMapper.getProfesorPorId(ID_PROFESOR)).thenReturn(new ProfesorBean());
		
		sut.getProfesorPorId(ID_PROFESOR);
		
		verify(profesorMapper).getProfesorPorId(ID_PROFESOR);
		
		verify(profesorMapper, Mockito.never()).getAll();
		verify(profesorMapper, Mockito.never()).selectNombre(ID_PROFESOR);
	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperGetProfesorPorIdReturnsNull(){
		
		when(profesorMapper.getProfesorPorId(ID_PROFESOR)).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getProfesorPorId(ID_PROFESOR);
	}
	
	@Test
	public void shouldCallMapperGetAllWhenCallServiceGetAll() {

		when(profesorMapper.getAll()).thenReturn(mock(List.class));
		
		sut.getAll();
		
		verify(profesorMapper).getAll();

	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperGetAllReturnsNull(){
		
		when(profesorMapper.getAll()).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getAll();
	}
	
	@Test
	public void shouldCallMapperGetAllWhenCallServiceSelectNombre() {

		when(profesorMapper.selectNombre(ID_PROFESOR)).thenReturn(new String());
		
		sut.selectNombre(ID_PROFESOR);
		
		verify(profesorMapper).selectNombre(ID_PROFESOR);

	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperSelectNombreReturnsNull(){
		
		when(profesorMapper.selectNombre(ID_PROFESOR)).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.selectNombre(ID_PROFESOR);
	}
	
	@Test
	public void shouldCallMapperInsertWhenCallServiceInsert() {
		
		sut.insert(new ProfesorBean());
		
		verify(profesorMapper).insert(new ProfesorBean());

	}
}

