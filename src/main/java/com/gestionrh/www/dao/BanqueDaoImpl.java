package com.gestionrh.www.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestionrh.www.entities.Banques;



public class BanqueDaoImpl implements IBanque {

	@PersistenceContext
	private EntityManager em;

	public Banques ajouterBanque(Banques b) {
		// TODO Auto-generated method stub
 		em.persist(b);
		return b;
	}

	public Banques getBanqueById(Long idBanque) {
		// TODO Auto-generated method stub

		Banques b = new Banques();
		b = em.find(Banques.class, idBanque);
		if(b == null){
			throw new RuntimeException("Banque introuvable !!!");
		}
		
		
		return b;
	}

	public List<Banques> getAllBanques() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select b from Banques b");
		return req.getResultList();
	}

	public Banques modifierBanque(Banques b){
		em.merge(b);
		return b;
	}

	public void supprimerBanque(Long idBanque) {
		Banques b = new Banques();
		b = em.find(Banques.class, idBanque);
		if(b == null){
			throw new RuntimeException("Banque introuvable !!!");
		}
		else{
			em.remove(b);
		}
	}


	public Banques getBanqueByAgence(Long idAgence) {
		Query req = em.createQuery("select b from Banques b, Agences a where a.banque = b.idBanque and a.idAgence=:x");
		req.setParameter("x", idAgence);
		return (Banques) req.getResultList().get(0);
	}
}
