package com.appli.chatflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.chatflow.entity.Message;
import com.appli.chatflow.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	// recuperer la liste des messages par canal
	public List<Message> recupererMessages(int idCanal){
		return messageRepository.recupererMessageByIdCanal(idCanal);
	}
	
	// Ajouter un message
	public Message ajouterMessage(Message message) {
		return messageRepository.save(message);
	}

}
