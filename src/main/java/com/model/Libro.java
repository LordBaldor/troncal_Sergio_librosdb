package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLibro;

	private String autor;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_publicación")
	private Date fechaPublicación;

	private String título;

	public Libro() {
	}

	public int getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechaPublicación() {
		return this.fechaPublicación;
	}

	public void setFechaPublicación(Date fechaPublicación) {
		this.fechaPublicación = fechaPublicación;
	}

	public String getTítulo() {
		return this.título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

}