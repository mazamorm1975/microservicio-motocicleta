package com.moto.service;

import java.util.List;
import java.util.Optional;

import com.moto.models.Motocicleta;

public interface MotocicletaService {

	List<Motocicleta> listar() throws Exception;
	Motocicleta registrar(Motocicleta moto) throws Exception;
	Motocicleta listarPorMotoId(int id) throws Exception;
	List<Motocicleta> totalMotosUsuarioId(int id) throws Exception;
	
}
