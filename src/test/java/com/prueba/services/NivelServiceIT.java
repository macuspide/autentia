package com.prueba.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context-test.xml"})
public class NivelServiceIT {

	@Autowired
	NivelService sut;
	
	@Test
	public void getNivelByIdShouldReturnNotNull(){
		sut.getNivel(1);
	}
	
}
