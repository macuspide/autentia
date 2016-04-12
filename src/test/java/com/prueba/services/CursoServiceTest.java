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

import com.prueba.beans.CursoBean;
import com.prueba.beans.NivelBean;
import com.prueba.beans.ProfesorBean;
import com.prueba.mappers.CursoMapper;

public class CursoServiceTest {
	
	CursoService sut;
	
	CursoMapper cursoMapper;
	
	private static final int N_HORAS = 33;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Before
	public void init(){
		
		this.cursoMapper = mock(CursoMapper.class);
		
		sut = new CursoService(cursoMapper);
	}
	
	@Test
	public void shouldCallMapperSelectTituloWhenCallServiceSelectTitulo(){
		
		when(cursoMapper.selectTitulo(N_HORAS)).thenReturn(new String());
		
		sut.selectTitulo(N_HORAS);
		
		verify(cursoMapper).selectTitulo(N_HORAS);
		
		verify(cursoMapper, Mockito.never()).getAll();
		verify(cursoMapper, Mockito.never()).getAllActivos();
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowRuntimeExceptionWhenMapperSelectTituloReturnsNull(){
		
		when(cursoMapper.selectTitulo(N_HORAS)).thenReturn(null);	
		sut.selectTitulo(N_HORAS);
	}
	
	@Test
	public void shouldCallMapperGetAllWhenCallServiceGetAll() {

		when(cursoMapper.getAll()).thenReturn(mock(List.class));
		
		sut.getAll();
		
		verify(cursoMapper).getAll();

	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperGetAllCursosReturnsNull(){
		
		when(cursoMapper.getAll()).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getAll();
	}
	
	@Test
	public void shouldCallMapperGetAllWhenCallServiceGetAllActivos() {

		when(cursoMapper.getAllActivos()).thenReturn(mock(List.class));
		
		sut.getAllActivos();
		
		verify(cursoMapper).getAllActivos();

	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenMapperGetAllActivosReturnsNull(){
		
		when(cursoMapper.getAllActivos()).thenReturn(null);
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Error al ejecutar la consulta");
		sut.getAllActivos();
	}
	
	@Test
	public void shouldCallMapperInsertWhenCallServiceInsert() {
		
		CursoBean curso = new CursoBean();
		
		sut.insert(curso);
		
		verify(cursoMapper).insert(curso);

	}
}

