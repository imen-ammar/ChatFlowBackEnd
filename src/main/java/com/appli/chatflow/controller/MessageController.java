package com.appli.chatflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appli.chatflow.entity.Message;
import com.appli.chatflow.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/recuperer")
	public List<Message> recupererMessageByIdCanal(@RequestParam int idCanal){
		return messageService.recupererMessages(idCanal);
	}
	
	@PostMapping("/save")
	public Message sauvegarderMessage(@RequestBody Message message) {
		return messageService.ajouterMessage(message);
	}

}
