package com.micro.respuestas.services;

//import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import com.commons.examenes.models.entity.Examen;
//import com.commons.examenes.models.entity.Pregunta;
//import com.micro.respuestas.clients.ExamenFeingClient;
import com.micro.respuestas.model.entity.Respuesta;
import com.micro.respuestas.repository.RespuestaRepository;

@Service
public class RespuestaServicesImpl implements RespuestaService {

	@Autowired
	private RespuestaRepository repo;
	
	//@Autowired
	//private ExamenFeingClient examenFeinClient;
	
	@Override
	//@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repo.saveAll(respuestas);
	}

	@Override
	//@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		//return repo.findRespuestaByAlumnoByExamen(alumnoId, examenId);
		/*
		 * Examen examen = examenFeinClient.obtenerExamenPorId(examenId);
		
		List<Pregunta> preguntas = examen.getPreguntas(); 
		List<Long> preguntasId = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) repo.findRespuestaByAlumnoByPreguntasIds(alumnoId, preguntasId);
		
		respuestas = respuestas.stream().map(r -> {
			preguntas.forEach(p->{
				if (p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());
		*/
		List<Respuesta> respuestas = (List<Respuesta>) repo.findRespuestaByAlumnoByExamen(alumnoId, examenId);
		
		return respuestas;
	}

	@Override
	//@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {		
		//return repo.findExamenesIdsConRespuestasByAlumno(alumnoId);
		/*
		List<Respuesta> respuestasAlumno = (List<Respuesta>) repo.findByAlumnoId(alumnoId);
		List<Long> examenIds = Collections.emptyList();
		
		if (respuestasAlumno.size() > 0) {
			List<Long> preguntasIds = respuestasAlumno.stream().map(r -> r.getPreguntaId()).collect(Collectors.toList());
			examenIds = examenFeinClient.obtenerExamenesIdsPorPreguntasIdRespondidas(preguntasIds);
		}
		*/
		
		List<Respuesta> respuestasAlumno = (List<Respuesta>) repo.findExamenesIdsConRespuestasByAlumno(alumnoId);
		List<Long> examenIds = respuestasAlumno.stream().map(r -> r.getPregunta().getExamen().getId()).distinct().collect(Collectors.toList());
				
		return examenIds;
	}

	@Override
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
		return repo.findByAlumnoId(alumnoId);
	}

}
