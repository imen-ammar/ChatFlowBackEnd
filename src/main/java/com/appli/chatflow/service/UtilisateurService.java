package com.appli.chatflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.chatflow.entity.Utilisateur;
import com.appli.chatflow.repository.UtilisateurRepository;

/**
 * Classe permettant de créer des services afin de gérer les utilisateurs
 *
 */
@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	/**
	 * Méthode qui permet de sauvegarder un utilisateur si la table utilisateur est
	 * vide
	 * 
	 * @param utilisateur Un utilisateur
	 * @return Un utilisateur si la sauvegarde s'est bien déroulée, null sinon
	 */
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

		if (utilisateurRepository.findAll().isEmpty()) {
			utilisateurRepository.save(utilisateur);
			return utilisateur;
		}
		return null;
	}
	

}
