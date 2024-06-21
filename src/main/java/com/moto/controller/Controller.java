package com.moto.controller;

import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.models.Motocicleta;
import com.moto.serviceImpl.ServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/motocicleta")
public class Controller {

	@Autowired
	private ServiceImplementation serviceMotoImpl;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Motocicleta> registrarMoto(@RequestBody Motocicleta moto) throws Exception{
		
		Motocicleta moto_2 = serviceMotoImpl.registrar(moto);
		
		return new ResponseEntity<Motocicleta>(moto_2, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/buscarPorID/{id}")
	public ResponseEntity<Motocicleta> buscarPorID(@PathVariable("id") int id) throws  Exception {
		
		Motocicleta moto =  serviceMotoImpl.listarPorMotoId(id);
		
		return new ResponseEntity<>(moto, HttpStatus.OK);
	}
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Motocicleta>> busquedaGeneral() throws Exception{
		
		List<Motocicleta> listadoCompletado = serviceMotoImpl.listar();
		
		return new ResponseEntity<List<Motocicleta>>(listadoCompletado, HttpStatus.OK);
	}
	
	@GetMapping("/obtenerTotalMotosPorUsuario/{usuarioId}")
	public ResponseEntity<List<Motocicleta>> totalMotosPorIdUsuario(@PathVariable("usuarioId") int usuarioId) throws Exception{
		
	 List<Motocicleta> motoId = serviceMotoImpl.totalMotosUsuarioId(usuarioId);
		
		return new ResponseEntity<List<Motocicleta>>(motoId, HttpStatus.OK);
	}
	
	
}
