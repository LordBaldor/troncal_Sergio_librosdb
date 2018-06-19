package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.model.Libro;

@Component
public class LibroService {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Transactional
	public void register(Libro libro) throws Exception {
		try {
			this.em.persist(libro);
			// this.em.persist(null);
		} catch (Exception e) {
			throw new Exception("Error al registrar");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Libro> listar() {

		return em.createQuery("from Libro l").getResultList();

	}

	@Transactional
	public void eliminar(Libro libro) throws Exception {

		try {
			Libro l = em.find(Libro.class, libro.getIdLibro());
			em.remove(l);
			// em.remove(null);
		} catch (Exception e) {
			throw new Exception("Error al eliminar");
		}
	}

	@Transactional
	public void modificar(Libro libro) throws Exception {
		try {
			em.merge(libro);
			// em.merge(null);
		} catch (Exception e) {
			throw new Exception("Error al modificar");
		}
	}

}
