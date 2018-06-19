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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLibro;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_publicación")
	private Date fechaPublicación;

	private String título;

	//bi-directional many-to-one association to Autores
	@ManyToOne
	@JoinColumn(name="idAutor_FK")
	private Autores autore;

	public Libro() {
	}

	public int getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
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

	public Autores getAutore() {
		return this.autore;
	}

	public void setAutore(Autores autore) {
		this.autore = autore;
	}

}