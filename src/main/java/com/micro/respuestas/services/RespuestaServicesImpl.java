package com.micro.respuestas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.respuestas.model.entity.Respuesta;
import com.micro.respuestas.repository.RespuestaRepository;

@Service
public class RespuestaServicesImpl implements RespuestaService {

	@Autowired
	private RespuestaRepository repo;
	
	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repo.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		return repo.findRespuestaByAlumnoByExamen(alumnoId, examenId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {		
		return repo.findExamenesIdsConRespuestasByAlumno(alumnoId);
	}

}
