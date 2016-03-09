package com.prueba.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.prueba.beans.NivelBean;

public interface NivelMapper {

	@Select("Select n.id_nivel, n.nombre_nivel from nivel n where n.id_nivel=#{id_nivel}")
	NivelBean getNivel(int id_nivel);
	
	

	@Select("Select id_nivel, nombre_nivel from nivel")
	@Results(value ={
	        @Result(property = "id_nivel", column = "id_nivel", id = true),
	        @Result(property = "nombre_nivel", column = "nombre_nivel"),
	})
	@Options(useCache=true)
	List<NivelBean> getAllNiveles();
}
