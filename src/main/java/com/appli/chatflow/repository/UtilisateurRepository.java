package com.appli.chatflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appli.chatflow.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	

}
