package com.appli.chatflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.chatflow.entity.Message;
import com.appli.chatflow.repository.MessageRepository;

/**
 * Classe permettant de créer des services afin de gérer les messages
 *
 */
@Service
public class MessageService {

	@Autowired // Injection des dépendances
	MessageRepository messageRepository;

	/**
	 * Méthode qui permet de recuperer la liste des messages par canal
	 * 
	 * @param idCanal Identifiant du canal
	 * @return une liste de message
	 */
	public List<Message> recupererMessages(int idCanal) {
		return messageRepository.recupererMessagesByIdCanal(idCanal);
	}

	/**
	 * Méthode qui permet de sauvegarder un message
	 * 
	 * @param message Le message
	 * @return Le message enregistré
	 */
	public Message ajouterMessage(Message message) {
		return messageRepository.save(message);
	}
}
