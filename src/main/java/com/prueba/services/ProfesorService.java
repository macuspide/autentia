package com.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.beans.ProfesorBean;
import com.prueba.mappers.ProfesorMapper;

@Service
@Component
public class ProfesorService implements IProfesorService {
	
	private ProfesorMapper profesorMapper;

	@Autowired
	public ProfesorService(ProfesorMapper profesorMapper){
		this.profesorMapper = profesorMapper;

	}
	
	@Override
	public List<ProfesorBean> getAll(){
		List<ProfesorBean> beans=profesorMapper.getAll();
		if(beans==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return beans;
	}

	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	@Transactional
	public void insert(ProfesorBean profesorbean){
		profesorMapper.insert(profesorbean);
	}
	
	@Override
	public ProfesorBean getProfesorPorId(int id_profesor){
		ProfesorBean profesorbean = profesorMapper.getProfesorPorId(id_profesor);
		if(profesorbean==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return profesorbean;
	}
	
	@Override
	public String selectNombre(int id_profesor){
		String nombre_profe=profesorMapper.selectNombre(id_profesor);
		if(nombre_profe==null){
			throw new NullPointerException("Error al ejecutar la consulta");
		}
		return nombre_profe;
	}	
}
