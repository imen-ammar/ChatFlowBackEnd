package com.appli.chatflow.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entité Message
 *
 */
@Entity // Spécifie que la classe est une entité
@Table(name = "message") // Spécifie le nom de la table dans la BDD
public class Message {

	@Id // Spécifie que l'attribut id est la clé primaire de la table utilisateur
	// Déclaration de la séquence seq_message qui va gérer la clé primaire de la table message
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message")
	@SequenceGenerator(name = "seq_message", allocationSize = 1)
	private int id;

	@Column(nullable = false) // Colonne non null
	private String contenu;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Paris"));

	@ManyToOne // Lien plusieurs à 1 : c.à.d. plusieurs messages sont liés à un canal
	@JoinColumn(name = "id_canal") // Spécifie le nom de la colonne à ajouter dans la table message
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Autorise l'affichage de cet attribut que lors de l'écriture
	private Canal canal;

	public Message() {
	}

	public Message(int id, String contenu, LocalDateTime time) {
		this.id = id;
		this.contenu = contenu;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
