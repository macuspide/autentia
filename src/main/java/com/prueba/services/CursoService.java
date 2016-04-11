package com.prueba.services;

import java.util.List;
import com.prueba.beans.CursoBean;
import com.prueba.mappers.CursoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService implements ICursoService{
	
	private CursoMapper cursoMapper;
	
	@Autowired
	public CursoService(CursoMapper cursoMapper){
		this.cursoMapper = cursoMapper;
	}

	@Override
	public String selectTitulo(int horas){
		
		String titulo=cursoMapper.selectTitulo(horas);
		
		if(titulo==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return titulo;
	}

	@Override
	public List<CursoBean> getAll(){
		List<CursoBean> beans=cursoMapper.getAll();
		if(beans==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return beans;
	}
	
	@Override
	public List<CursoBean> getAllActivos(){
		List<CursoBean> beans=cursoMapper.getAllActivos();
		if(beans==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return beans;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert(CursoBean cursobean){
		cursoMapper.insert(cursobean);
	}
	
}
