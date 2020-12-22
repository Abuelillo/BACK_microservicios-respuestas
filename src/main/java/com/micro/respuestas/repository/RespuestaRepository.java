package com.micro.respuestas.repository;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.micro.respuestas.model.entity.Respuesta;

//public interface RespuestaRepository extends MongoRepository<Respuesta, Long> {
public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

	//@Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
	//public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId,Long examenId);
	@Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1} }")
	public Iterable<Respuesta> findRespuestaByAlumnoByPreguntasIds(Long alumnoId,Iterable<Long> preguntasId);
	
	//@Query("select e.id from Respuesta r join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
	//public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
	@Query("{'alumnoId': ?0}")
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
}
