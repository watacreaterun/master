package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ReservationForm;
import com.example.demo.service.ReservationService;

@Controller
public class CompleteController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/complete")
	public String completeReservation(@ModelAttribute ReservationForm reservationForm) {
//			reservationService.updateReservation(reservationForm);
			reservationService.saveReservation(reservationForm);

		return "redirect:complete";
	}
	
	@PostMapping("/reserve_update_complete")
	public String reserveUpdateCompleteReservation(@ModelAttribute ReservationForm reservationForm) {
		reservationService.updateReservation(reservationForm);
		
		return "redirect:complete";
	}
}
