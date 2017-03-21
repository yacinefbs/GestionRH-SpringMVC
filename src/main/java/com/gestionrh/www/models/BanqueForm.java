package com.gestionrh.www.models;

import java.util.List;

import javax.validation.constraints.Size;

import com.gestionrh.www.entities.Banques;

public class BanqueForm {

	
	private Long idBanque;
	@Size(min=3, max=20, message="Le nom de la banque doît être compris entre 3 et 20 lettres")
	private String nomBanque;
	
	private List<Banques> banques;
	
	
	public Long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	public String getNomBanque() {
		return nomBanque;
	}
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	public List<Banques> getBanques() {
		return banques;
	}
	public void setBanques(List<Banques> banques) {
		this.banques = banques;
	}
}
