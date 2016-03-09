package com.prueba.services;

import java.util.List;

import com.prueba.beans.NivelBean;

public interface INivelService {
	NivelBean getNivel(int id_nivel);
	List<NivelBean> getAllNiveles();
}
