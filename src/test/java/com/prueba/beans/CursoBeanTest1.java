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
import org.mockito.Mockito;

import com.prueba.beans.NivelBean;
import com.prueba.mappers.NivelMapper;
import com.prueba.services.NivelService;
import com.prueba.beans.CursoBean;

public class CursoBeanTest1 {
	
	CursoBean sut;	
	
	@Test
	public void shouldCreateNewCursoBean(){
		CursoBean n=new CursoBean("titulo",1,new NivelBean(),22,true,1,new ProfesorBean());
		assertEquals(n.getClass(), CursoBean.class);
		
	}

}
