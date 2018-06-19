package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autores database table.
 * 
 */
@Entity
@NamedQuery(name="Autores.findAll", query="SELECT a FROM Autores a")
public class Autores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAutor;

	private String apellido;

	private String nacionalidad;

	private String nombre;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="autore")
	private List<Libro> libros;

	public Autores() {
	}

	public int getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro addLibro(Libro libro) {
		getLibros().add(libro);
		libro.setAutore(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setAutore(null);

		return libro;
	}

}