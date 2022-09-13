package com.appli.chatflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appli.chatflow.entity.Utilisateur;
import com.appli.chatflow.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired

	UtilisateurService utilisateurService;

	@PostMapping
	public Utilisateur ajoutUtilisateur(@RequestBody Utilisateur utilisateur) {

		return utilisateurService.saveUtilisateur(utilisateur);

	}

}
