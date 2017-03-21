package com.gestionrh.www.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionrh.www.dao.BanqueDaoImpl;
import com.gestionrh.www.dao.IBanque;
import com.gestionrh.www.entities.Banques;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	
	private IBanque dao = new BanqueDaoImpl();
	
	
	
	public void setDao(IBanque dao) {
		this.dao = dao;
	}

	public Banques ajouterBanque(Banques b) {
		// TODO Auto-generated method stub
		return dao.ajouterBanque(b);
	}
	
	public Banques getBanqueById(Long idBanque){
		return dao.getBanqueById(idBanque);
	}
	public List<Banques> getAllBanques() {
		// TODO Auto-generated method stub
		return dao.getAllBanques();
	}
	
	public Banques modifierBanque(Banques b){
		return dao.modifierBanque(b);
	}
	
	public void supprimerBanque(Long idBanque){
		dao.supprimerBanque(idBanque);
	}

	public Banques getBanqueByAgence(Long idAgence) {
		// TODO Auto-generated method stub
		return dao.getBanqueByAgence(idAgence);
	}
}