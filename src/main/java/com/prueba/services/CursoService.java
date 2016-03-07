package com.prueba.services;

import java.util.List;

import com.prueba.beans.CursoBean;
import com.prueba.mappers.CursoMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService implements ICursoService{
	@Autowired
	private CursoMapper cursoMapper;
	
	public void setCursoMapper(CursoMapper cursoMapper) {
		this.cursoMapper = cursoMapper;
	}
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public String selectTitulo(int horas){
		
		String titulo=cursoMapper.selectTitulo(horas);
		
		if(titulo==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return titulo;
	}

	public List<CursoBean> getAll(){
		List<CursoBean> beans=cursoMapper.getAll();
		if(beans==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return beans;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert(CursoBean cursobean){
		cursoMapper.insert(cursobean);
	}
	
	public String getNivel(int id_nivel){
		String nivel=cursoMapper.getNivel(id_nivel);
		if(nivel==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return nivel;
	}
}
