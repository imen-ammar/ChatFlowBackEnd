package com.appli.chatflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.ApiOperation;

/**
 * Classe permettant d'exposer des Webservices REST afin de gérer les canaux
 *
 */
@RestController

@RequestMapping("/canal")
public class CanalController {

	@Autowired
	CanalService canalservice;

	@GetMapping("/allcanals")
	@ApiOperation(value = "API that will list all the canal")
	public List<Canal> getallCanal() {
		return canalservice.getCanals();
	}

	@PostMapping("/ajoutcanal")
	@ApiOperation(value = "API that will Add new canal")
	public Canal AddCanal(@RequestBody Canal canal) {
		return canalservice.ajouterCanal(canal);
	}

	@PutMapping("/modifycanal")
	@ApiOperation(value = "API that will update canal")
	public Canal updateCanal(@RequestBody Canal canal) {
		return canalservice.modifierCanal(canal);
	}

	@DeleteMapping("/deletecanal/{id}")
	@ApiOperation(value = "API that will remove canal")
	public void deleteCanal(@PathVariable int idCanal) {
		canalservice.deleteCanal(idCanal);
	}

	@GetMapping("/canalbyuser")
	@ApiOperation(value = "API that will list the canal by user Id")
	public List<Canal> getCanalByUser(@RequestParam int idUtilisateur) {
		return canalservice.SearchCanalByUserId(idUtilisateur);

	}
}
