package com.prueba.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.beans.NivelBean;
import com.prueba.mappers.NivelMapper;

@Service
public class NivelService implements INivelService {
	
	@Autowired
	private NivelMapper nivelMapper;
	
	public void setNivelMapper(NivelMapper nivelMapper) {
		this.nivelMapper = nivelMapper;
	}


	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public NivelBean getNivel(int id_nivel){
		NivelBean nivelbean = nivelMapper.getNivel(id_nivel);
		if(nivelbean==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return nivelbean;
	}
	
	public List<NivelBean> getAllNiveles(){
		List<NivelBean> niveles = nivelMapper.getAllNiveles();
		if(niveles==null){
			throw new RuntimeException("Error al ejecutar la consulta");
		}
		return niveles;
	}
}
