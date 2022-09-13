package com.appli.chatflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.chatflow.entity.Canal;


public interface CanalRepository extends JpaRepository<Canal, Integer>{
	
	@Query("SELECT c FROM Canal c WHERE c.utilisateur.id =:id")
	public List<Canal> getCanalByUserId(@Param("id") int id);
}
