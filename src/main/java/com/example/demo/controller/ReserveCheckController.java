package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

import jakarta.transaction.Transactional;

@Controller
public class ReserveCheckController {
	
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReserveCheckController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}


	@GetMapping("/reserve_check")
	public String reserveCheck(Model model) {
			List<Reservation> reserves = reservationRepository.findAll();
			model.addAttribute("reserves", reserves);
		return "reserve_check";
	}
	
	@GetMapping("/reserve_check_detail/{reserveId}")
	public String reserveCheckDetail(@PathVariable("reserveId") int reserveId, Model model) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(reserveId);
		
			model.addAttribute("reserve", optionalReservation.get());
		
		return "reserve_check_detail";
	}
	
	@GetMapping("/reserve_update/{reserveId}")
	public String reserveUpdate(@PathVariable("reserveId") int reserveId, Model model) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(reserveId);
		
			model.addAttribute("reserve", optionalReservation.get());
		
		return "reserve_update";
	}
	
	@Transactional
    @GetMapping("/delete_reservation/{reserveId}")
    public String deleteReservation(@PathVariable("reserveId") int reserveId) {
        reservationRepository.deleteById(reserveId);
        return "redirect:/reserve_check";
    }
}