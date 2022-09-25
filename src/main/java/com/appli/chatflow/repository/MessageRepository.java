package com.appli.chatflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.chatflow.entity.Message;

/**
 * Interface permettant de gérer les messages
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

	/**
	 * Méthode permettant de récupérer la liste des messages d'un canal
	 * @param idCanal Identifiant d'un canal
	 * @return La liste des messages d'un canal
	 */
	@Query("SELECT m FROM Message m WHERE m.canal.id = :idCanal ORDER BY m.time DESC")
	public List<Message> recupererMessagesByIdCanal(@Param("idCanal") int idCanal);
	

}
