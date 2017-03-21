package com.gestionrh.www.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Salaries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSalarie;
	@NotNull(message="Veuillez saisir le nom !!!")
	private String nom;
	@NotNull(message="Veuillez saisir le prénom")
	private String prenom;
	private String CIN;
	private String telephone_pro;
	private String telephone_portable;
	private String telecopie;
	private String email;
	private String situationFamiliale;
	private int nbEnfants;
	private String ribSalaire;
	private String sexe;
	private String cnss;
	
	@ManyToOne
	@JoinColumn(name="idBanque")
	private Banques banque;

	public Salaries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salaries(String nom, String prenom, String cIN, String telephone_pro, String telephone_portable,
			String telecopie, String email, String situationFamiliale, int nbEnfants, String ribSalaire, String sexe,
			String cnss) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.telephone_pro = telephone_pro;
		this.telephone_portable = telephone_portable;
		this.telecopie = telecopie;
		this.email = email;
		this.situationFamiliale = situationFamiliale;
		this.nbEnfants = nbEnfants;
		this.ribSalaire = ribSalaire;
		this.sexe = sexe;
		this.cnss = cnss;
	}

	public Long getIdSalarie() {
		return idSalarie;
	}

	public void setIdSalarie(Long idSalarie) {
		this.idSalarie = idSalarie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getTelephone_pro() {
		return telephone_pro;
	}

	public void setTelephone_pro(String telephone_pro) {
		this.telephone_pro = telephone_pro;
	}

	public String getTelephone_portable() {
		return telephone_portable;
	}

	public void setTelephone_portable(String telephone_portable) {
		this.telephone_portable = telephone_portable;
	}

	public String getTelecopie() {
		return telecopie;
	}

	public void setTelecopie(String telecopie) {
		this.telecopie = telecopie;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getRibSalaire() {
		return ribSalaire;
	}

	public void setRibSalaire(String ribSalaire) {
		this.ribSalaire = ribSalaire;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public Banques getBanque() {
		return banque;
	}

	public void setBanque(Banques banque) {
		this.banque = banque;
	}
}