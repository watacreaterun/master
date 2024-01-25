package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reservation;

public interface  ReservationRepository extends JpaRepository<Reservation, Long>{
	Optional<Reservation> findById(int id);
	
	 void deleteById(int reserveId);
}
