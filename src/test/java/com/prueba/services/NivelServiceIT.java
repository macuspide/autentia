package com.prueba.services;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prueba.beans.NivelBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context-test.xml"})
public class NivelServiceIT {

	@Autowired
	NivelService sut;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void getNivelByIdShouldReturnNotNull(){
		sut.getNivel(1);
	}
	
	@Test
	public void getNivelByIdShouldReturnNNull(){
		sut.getNivel(1);
	}
	
	@Test
	public void getNivelByIdShouldReturnNivelBean(){
		assertEquals(sut.getNivel(1).getClass(), NivelBean.class);
	}
	
	@Test
	public void getAllNivelesShouldReturnNotNull(){
		sut.getAllNiveles();
	}
	
	@Test
	public void getAllNivelesShouldReturnList(){
		assertEquals(sut.getAllNiveles().getClass(), ArrayList.class);
		sut.getAllNiveles();
	}
	
	//expectedException.expect(RuntimeException.class);
	//expectedException.expectMessage("Error al ejecutar la consulta");
	
}
