package com.appli.chatflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.chatflow.entity.Canal;
import com.appli.chatflow.repository.CanalRepository;

@Service
public class CanalService {

	@Autowired
	CanalRepository canalRepo;
	
	/**
	 * Method to extract all the canals 
	 * @return
	 */

	public List<Canal> getCanals() {
		return canalRepo.findAll();
	}
	
	/**
	 * Method to add a row/data in table/entity canal 
	 * @param canal
	 * @return
	 */
	

	public Canal ajouterCanal(Canal canal) {

		return canalRepo.save(canal);
	}
	
	/**
	 * Method to do modification in each tulip/row 
	 * @param canal
	 * @return
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
	 * Method to delete a row from table 
	 * @param id
	 */
	public void deleteCanal(int id) {
		
		// Condition to verify if the canal of given id is not empty , 
		//if it is not empty delete the row 

		if (canalRepo.findById(id).orElse(null) != null) {

			canalRepo.deleteById(id);
		}

	}
	
	/**
	 * Method to search Canal by user id 
	 * @param id
	 * @return
	 */

	public List<Canal> SearchCanalByUserId(int id) {
		return canalRepo.getCanalByUserId(id);

	}
}
