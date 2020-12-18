package com.micro.respuestas.services;

import com.micro.respuestas.model.entity.Respuesta;

public interface RespuestaService {
	
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);

	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId,Long examenId);
	
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
