package com.appli.chatflow.entity;

import java.util.Date;

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

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message")
	@SequenceGenerator(name = "seq_message", allocationSize = 1)
	private int id;

	@Column(nullable = false)
	private String contenu;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time = new Date();

	@ManyToOne
	@JoinColumn(name = "id_canal")
	private Canal canal;

	public Message() {
	}

	public Message(int id, String contenu, Date time) {
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
