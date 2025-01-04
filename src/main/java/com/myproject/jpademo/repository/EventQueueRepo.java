package com.myproject.jpademo.repository;

import com.myproject.jpademo.models.EventQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventQueueRepo extends JpaRepository<EventQueue, Integer> {

}
