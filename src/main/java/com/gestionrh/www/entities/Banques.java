package com.gestionrh.www.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banques {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBanque;
	private String nomBanque;
	
	
	@OneToMany(mappedBy="banque", fetch = FetchType.LAZY)
	private List<Salaries> salaries;
	
	//Debut : relations
	

	//Fin : relations
	
	
	public Banques() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banques(String nomBanque) {
		super();
		this.nomBanque = nomBanque;
	}
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
	public List<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(List<Salaries> salaries) {
		this.salaries = salaries;
	}
}
