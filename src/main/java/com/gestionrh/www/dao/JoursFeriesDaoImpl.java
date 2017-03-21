package com.gestionrh.www.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gestionrh.www.entities.JourFeries;


public class JoursFeriesDaoImpl{
	
	@PersistenceContext
	private EntityManager em;

	public void ajouterJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
		em.persist(j);
	}
}
