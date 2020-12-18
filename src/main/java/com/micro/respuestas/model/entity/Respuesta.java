package com.micro.respuestas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.commons.examenes.models.entity.Pregunta;
import com.micro.common.alumnos.models.entity.Alumno;

@Entity
@Table(name="respuestas")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String texto;	
	
	//@ManyToOne(fetch = FetchType.LAZY) //muchas respuestas a un alumno
	@Transient
	private Alumno alumno;
	
	@Column(name = "alumno_id")
	private Long alumnoId;
	
	@OneToOne(fetch = FetchType.LAZY) //una respuesta a una pregunta
	private Pregunta pregunta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}	
	public Alumno getAlumno() {
		return alumno;
	}	
	public Long getAlumnoId() {
		return alumnoId;
	}
	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", texto=" + texto + "]";
	}	
}