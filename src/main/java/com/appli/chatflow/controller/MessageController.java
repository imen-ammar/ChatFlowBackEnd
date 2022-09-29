package com.appli.chatflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appli.chatflow.entity.Message;
import com.appli.chatflow.service.MessageService;

import io.swagger.annotations.ApiOperation;

/**
 * Classe permettant d'exposer des Webservices REST afin de gérer les messages
 *
 */
@RestController // Spécifie que c'est un contrôleur REST
@RequestMapping("/message") // Spécifie le point d'entrée vers ce contrôleur
public class MessageController {
	
	@Autowired // Injection des dépendances
	MessageService messageService;
	
	@GetMapping("/recuperer") // Spécifie le verbe HTTP ainsi que le point d'entrée
	@ApiOperation(value = "API permettant de récupérer les messages d'un canal") // Documenttaion Swagger
	public List<Message> recupererMessageByIdCanal(@RequestParam int idCanal){
		return messageService.recupererMessages(idCanal);
	}
	
	@PostMapping("/save")
	@ApiOperation(value = "API permettant d'envoyer un message")
	public Message sauvegarderMessage(@RequestBody Message message) {
		return messageService.ajouterMessage(message);
	}

}
