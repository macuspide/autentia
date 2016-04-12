package com.prueba.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import com.prueba.beans.NivelBean;


public class NivelBeanTest {
	
	NivelBean  n;
	
	@Before
	public void init(){
		n=new NivelBean(1, "Basico");
	}
	
	@Test
	public void shouldCreateNewNivelBean(){
		
		assertEquals(n.getClass(), NivelBean.class);
		
	}
	
	@Test
	public void shouldReturnStringSetted(){
		
		n.setNombre_nivel("Avanzado");
		assertEquals(n.getNombre_nivel(), "Avanzado");
		
	}
	
	
	@Test
	public void shouldReturnIdNivelSetted(){
		
		n.setId_nivel(2);
		assertEquals(n.getId_nivel(), 2);
		
	}
}