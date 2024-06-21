package com.moto.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.models.Motocicleta;
import com.moto.repository.MotoRepository;
import com.moto.service.MotocicletaService;

@Service
public class ServiceImplementation implements MotocicletaService {

	@Autowired
	private MotoRepository motoRepo;
	
		
	@Override
	public List<Motocicleta> listar() throws Exception {
		
		List<Motocicleta> listadoGeneral = motoRepo.findAll();
		
		return listadoGeneral;
	}

	@Override
	public Motocicleta registrar(Motocicleta moto) throws Exception {
		
		return motoRepo.save(moto);
	}

	@Override
	public Motocicleta listarPorMotoId(int id) throws Exception {
		
		Optional<Motocicleta> moto_2 = motoRepo.findById(id); 
		
		 return moto_2.isPresent() ? moto_2.get() : new Motocicleta();
	}

	@Override
	public List<Motocicleta> totalMotosUsuarioId(int id) throws Exception {
		
		List<Motocicleta> moto_3 = motoRepo.findByUsuarioId(id);
		
		return moto_3;
	}

	
}
