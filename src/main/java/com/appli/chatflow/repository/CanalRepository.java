package com.appli.chatflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.chatflow.entity.Canal;


/**
 * Interface permettant de gérer les canaux
 *
 */
public interface CanalRepository extends JpaRepository<Canal, Integer>{
	
	/**
	 * Méthode permettant de récupérer la liste des canaux d'un utilisateur
	 * @param idUtilisateur Identifiant de l'utilisateur
	 * @return La liste des canaux d'un utilisateur
	 */
	@Query("SELECT c FROM Canal c WHERE c.utilisateur.id =:idUtilisateur")
	public List<Canal> getCanalByUserId(@Param("idUtilisateur") int idUtilisateur);
}
