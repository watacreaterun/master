package com.example.demo.service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.model.ReservationForm;
import com.example.demo.repository.ReservationRepository;


@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void saveReservation(ReservationForm reservationForm) {
		Reservation reservation = new Reservation();
		reservation.setReserveDate(parseDate(reservationForm.getReserveDate()));
		reservation.setReserveTime(parseTime(reservationForm.getReserveTime()));
		reservation.setReserveNum(reservationForm.getReserveNum());
		reservation.setCustomerName(reservationForm.getCustomerName());
		reservation.setEmail(reservationForm.getEmail());
		reservation.setPhone(reservationForm.getPhone());
		reservation.setComment(reservationForm.getComment());
		
		reservationRepository.save(reservation);
	}
	
	private Date parseDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invaliddateformat: " + dateStr);
		}
	}

	private Time parseTime(String timeStr) {
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    try {
	        return new Time(timeFormat.parse(timeStr).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException("Invalid time format: " + timeStr);
	    }
	}

    public void updateReservation(ReservationForm reservationForm) {
        // 更新対象の予約IDをフォームから取得
        int reservationId = reservationForm.getId();

        // 予約IDから該当する予約情報を取得
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
            Reservation existingReservation = optionalReservation.get();

            // フォームから受け取った情報で既存の予約情報を更新
            existingReservation.setReserveDate(parseDate(reservationForm.getReserveDate()));
            existingReservation.setReserveTime(parseTime(reservationForm.getReserveTime()));
            existingReservation.setReserveNum(reservationForm.getReserveNum());
            existingReservation.setCustomerName(reservationForm.getCustomerName());
            existingReservation.setEmail(reservationForm.getEmail());
            existingReservation.setPhone(reservationForm.getPhone());
            existingReservation.setComment(reservationForm.getComment());

            // 更新をデータベースに反映
            reservationRepository.save(existingReservation);
    }
}
