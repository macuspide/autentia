package com.prueba.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import com.prueba.beans.NivelBean;


public class ProfesorBeanTest {
	
	ProfesorBean  p;
	
	@Before
	public void init(){
		p=new ProfesorBean(1, "Jose");
	}
	
	@Test
	public void shouldCreateNewProfesorBean(){
		
		assertEquals(p.getClass(), ProfesorBean.class);
		
	}
	
	@Test
	public void shouldReturnStringSetted(){
		
		p.setNombre_profe("Maria");
		assertEquals(p.getNombre_profe(), "Maria");
		
	}
	
	
	@Test
	public void shouldReturnIdProfesorSetted(){
		
		p.setId_profesor(2);
		assertEquals(p.getId_profesor(), 2);
		
	}
}