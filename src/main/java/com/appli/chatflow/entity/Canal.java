package com.appli.chatflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table( name = "canal")
public class Canal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_canal")
    @SequenceGenerator(name = "seq_canal", allocationSize = 1)
	
	private int id ; 
	@Column(nullable = false , unique= true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name ="id_utilisateur")
	private Utilisateur utilisateur; 
	
	
	
	
	public Canal() {
		super();
	}


	public Canal(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	} 
	
	
	

	
}
