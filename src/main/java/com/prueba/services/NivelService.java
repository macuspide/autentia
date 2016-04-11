package com.prueba.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.beans.NivelBean;
import com.prueba.mappers.NivelMapper;

@Service
public class NivelService implements INivelService {
	
	
	private NivelMapper nivelMapper;
	
	@Autowired
	public NivelService(NivelMapper nivelMapper){
		this.nivelMapper = nivelMapper;
	}
	
	@Override
	public NivelBean getNivel(int id_nivel){
		NivelBean nivelbean = nivelMapper.getNivel(id_nivel);
		
		if(nivelbean==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		
		return nivelbean;
	}
	
	@Override
	public List<NivelBean> getAllNiveles(){
		List<NivelBean> niveles = nivelMapper.getAllNiveles();
		if(niveles==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return niveles;
	}
}
