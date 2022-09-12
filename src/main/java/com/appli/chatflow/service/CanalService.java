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
	
	public List<Canal> getCanals(){
		return canalRepo.findAll();
	}
	
	
	public Canal ajouterCanal(Canal canal) {
		
		return canalRepo.save(canal);
	}
	
	
	public Canal modifierCanal(Canal canal) {
		
		Canal newcanal = canalRepo.findById(canal.getId()).orElse(null);
		
		newcanal.setNom(canal.getNom());
		
		canalRepo.save(newcanal);
		return newcanal;
		
	}
	
	
	public String deleteCanal(int id) {
		
		if (canalRepo.findById(id).orElse(null)!=null) {
			
			canalRepo.deleteById(id);
		}
		
		return "Canal not found with this id"+id;
	}
}
