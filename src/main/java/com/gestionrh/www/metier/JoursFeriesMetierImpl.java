package com.gestionrh.www.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionrh.www.dao.IJoursFeries;
import com.gestionrh.www.dao.JoursFeriesDaoImpl;
import com.gestionrh.www.entities.JourFeries;

@Transactional
public class JoursFeriesMetierImpl {
	
	JoursFeriesDaoImpl daoJour = new JoursFeriesDaoImpl();

	

	public void setDaoJour(JoursFeriesDaoImpl daoJour) {
		this.daoJour = daoJour;
	}




	public void ajouterJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
		daoJour.ajouterJourFeries(j);

	}

}

