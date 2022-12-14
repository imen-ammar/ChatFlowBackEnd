package com.appli.chatflow.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.chatflow.entity.Canal;
import com.appli.chatflow.repository.CanalRepository;
import com.appli.chatflow.repository.MessageRepository;

/**
 * Classe permettant de créer des services afin de gérer les canaux
 *
 */
@Service
public class CanalService {

	@Autowired
	CanalRepository canalRepo;

	@Autowired
	MessageRepository messageRepository;

	/**
	 * Method to extract all the canals and will return all the created canals in DB
	 * sorted is used to dispaly the list in order
	 * 
	 * @return list of canals
	 */
	public List<Canal> getCanals() {
		return canalRepo.findAll().stream().sorted(Comparator.comparing(Canal::getId)).collect(Collectors.toList());
	}

	/**
	 * Method to add a row/data in table/entity canal and save the data/ row that we
	 * want to insert in DB
	 * 
	 * @param canal
	 * @return addtion of a row in canal
	 */

	public Canal ajouterCanal(Canal canal) {
		return canalRepo.save(canal);
	}

	/**
	 * Method to do modification in each tulip/row and apply the modification on the
	 * data/row
	 * 
	 * @param canal
	 * @return canal with modification
	 */

	public Canal modifierCanal(Canal canal) {

		Canal newcanal = canalRepo.findById(canal.getId()).orElse(null);
		// condition to check if the field is not empty then it will create a new canal
		if (newcanal != null) {
			newcanal.setNom(canal.getNom());
			canalRepo.save(newcanal);
		}
		return newcanal;

	}

	/**
	 * Method to delete a row from table by using id that we give in Paramter
	 * 
	 * @param id
	 */
	public void deleteCanal(int id) {

		// Condition to verify if the canal of given id is not empty ,
		// if it is not empty delete the row
		if (canalRepo.findById(id).orElse(null) != null) {
			// supprimer les messages du canal
			messageRepository.supprimerMessageByIdCanal(id);
			// supprimer le canal
			canalRepo.deleteById(id);
		}
	}

	/**
	 * Method to search Canal by user id
	 * 
	 * @param id
	 * @return
	 */
	public List<Canal> SearchCanalByUserId(int id) {
		return canalRepo.getCanalByUserId(id);

	}
}
