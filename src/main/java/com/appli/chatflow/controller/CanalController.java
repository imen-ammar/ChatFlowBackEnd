package com.appli.chatflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appli.chatflow.entity.Canal;
import com.appli.chatflow.service.CanalService;


@RestController
@RequestMapping("/canal")
public class CanalController {

	@Autowired 
	CanalService canalservice; 
	
	
	@GetMapping("/allcanals")
	public List<Canal> getallCanal(){
		
		return canalservice.getCanals();	
		
	}
	
	@PostMapping("/ajoutcanal")
	public Canal AddCanal(@RequestBody Canal canal) {
		
		return canalservice.ajouterCanal(canal);
	}
	
	@PutMapping("/modifycanal")
	public Canal updateCanal(@RequestBody Canal canal) {
		
		return canalservice.modifierCanal(canal);
	}
	
	@DeleteMapping("/deletecanal/{id}")
	
	public void deleteCanal(@PathVariable int id) {
		
		canalservice.deleteCanal(id);
	}
	
	@GetMapping("/canalbyuser")
	
	public List<Canal> getCanalByUser(@RequestParam int id_utilisateur ){
		return canalservice.SearchCanalByUserId(id_utilisateur);
		
	}
}
