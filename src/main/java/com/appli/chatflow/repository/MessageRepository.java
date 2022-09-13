package com.appli.chatflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.chatflow.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query("SELECT m FROM Message m WHERE m.canal.id = :id ORDER BY m.time DESC")
	public List<Message> recupererMessageByIdCanal(@Param("id") int id);
	

}
