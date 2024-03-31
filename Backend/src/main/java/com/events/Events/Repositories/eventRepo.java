package com.events.Events.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.Events.model.events;

public interface eventRepo extends JpaRepository<events,Long>{

	List<events> findByDateBetweenOrderByDateAsc(LocalDate date,LocalDate Ldate);
}
