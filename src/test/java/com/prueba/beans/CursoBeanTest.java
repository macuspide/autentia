package com.prueba.beans;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prueba.beans.NivelBean;
import com.prueba.mappers.NivelMapper;
import com.prueba.services.NivelService;
import com.prueba.beans.CursoBean;

public class CursoBeanTest {
	
	CursoBean  c;
	
	@Before
	public void init(){
		c=new CursoBean("titulo",1,new NivelBean(),22,true,1,new ProfesorBean());
	}
	
	@Test
	public void shouldCreateNewCursoBean(){
		
		assertEquals(c.getClass(), CursoBean.class);
		
	}
	
	@Test
	public void shouldReturnStringSetted(){
		
		c.setTitulo("nuevo");
		assertEquals(c.getTitulo(), "nuevo");
		
	}
	
	
	@Test
	public void shouldReturnIdNivelSetted(){
		
		c.setId_nivel(2);
		assertEquals(c.getId_nivel(), 2);
		
	}
	
	@Test
	public void shouldReturnNivelBeanSetted(){
		NivelBean nb = new NivelBean();
		c.setNivelbean(nb);
		assertEquals(c.getNivelbean(), nb);
		
	}
	
	@Test
	public void shouldReturnIdProfesorSetted(){
		
		c.setId_profesor(2);
		assertEquals(c.getId_profesor(), 2);
		
	}
	
	@Test
	public void shouldReturnProfesorBeanSetted(){
		ProfesorBean pb = new ProfesorBean();
		c.setProfesorBean(pb);
		assertEquals(c.getProfesorBean(), pb);
		
	}
	
	@Test
	public void shouldReturnIntHorasSetted(){
		
		c.setHoras(22);
		assertEquals(c.getHoras(), 22);
		
	}
	
	@Test
	public void shouldReturnBooleanActivoSetted(){
		
		c.setActivo(false);
		assertEquals(c.isActivo(), false);
		
	}

}
