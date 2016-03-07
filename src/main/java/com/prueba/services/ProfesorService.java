package com.prueba.services;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.beans.CursoBean;
import com.prueba.beans.ProfesorBean;
import com.prueba.mappers.ProfesorMapper;

@Service
@Component
public class ProfesorService implements IProfesorService {
	@Autowired
	private ProfesorMapper profesorMapper;
	
	public void setProfesorMapper(ProfesorMapper profesorMapper){
		this.profesorMapper = profesorMapper;
	}
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public List<ProfesorBean> getAll(){
		List<ProfesorBean> beans=profesorMapper.getAll();
		if(beans==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return beans;
	}

	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Transactional
	public void insert(ProfesorBean profesorbean){
		profesorMapper.insert(profesorbean);
	}
	
	public String selectNombre(int id_profesor){
		String nombre_profe=profesorMapper.selectNombre(id_profesor);
		if(nombre_profe==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return nombre_profe;
	}	
}
