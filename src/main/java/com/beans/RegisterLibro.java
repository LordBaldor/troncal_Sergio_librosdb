package com.beans;


import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.model.Libro;
import com.service.LibroService;

@ManagedBean
@SessionScoped
public class RegisterLibro {

	private List<Libro> lstLibros;
	
	public List<Libro> getLstLibro() {
		listar();
		return lstLibros;
	}

	public void setLstEmpleados(List<Libro> lstLibro) {
		this.lstLibros = lstLibro;
	}

	@ManagedProperty("#{libroService}")
	private LibroService libroService;

	private Libro libro = new Libro();

	public LibroService getLibroService() {
		return libroService;
	}

	public void setEmployeeService(LibroService libroService) {
		this.libroService = libroService;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String register() {
		try {
			libroService.register(libro);
			listar();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("El libro "+this.libro.getTítulo()+" se ha registrado con éxito"));
			libro = new Libro();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Error al registrar"));
		}
		return "";
	}
	
	public boolean verificarSesion(){
		return true;      
	}
	
	public void listar(){
		
		lstLibros = libroService.listar();
	}
	
	public void eliminar(Libro libro) {
		try {
			libroService.eliminar(libro);
			listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Error al eliminar"));
		}
	}
	
	public String leer (Libro libro) {
		this.libro = libro;
		return "editar";
	}
	
	public void cerrarSesion() {
		
	}
	
	private TimeZone timeZone;
	public TimeZone getTimeZone() {  
		  TimeZone timeZone = TimeZone.getDefault();  
		  return timeZone;  
	}  
	
	public String modificar() {
		try {
			libroService.modificar(libro);
			listar();
			libro = new Libro();
			return "index?faces-redirect=true";
			
		} catch (Exception e) {
			libro = new Libro();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Error al modificar"));
			return "index";
		}
	}
	public String cancelar() {
		libro = new Libro();
		return "index?faces-redirect=true";
	}
}

