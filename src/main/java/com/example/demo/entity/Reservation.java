package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reserve")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "reserve_date") 
	private Date reserveDate;
	
	@Column(name = "reserve_time")
	private Time reserveTime;
	
	@Column(name = "reserve_num") 
	private int reserveNum;
	
	@Column(name = "customer_name") 
	private String customerName;
	
	@Column(name = "email") 
	private String email;
	
	@Column(name = "phone") 
	private String phone;
	
	@Column(name = "comment") 
	private String comment;
	
	/*	
		getter
	*/
	
	public Date getReserveDate() {
		return reserveDate;
	}
	
	public Time getReserveTime() {
		return reserveTime;
	}
	
	public int getReserveNum() {
		return reserveNum;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getComment() {
		return comment;
	}

	/*	
	setter
	 */
	
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	public void setReserveTime(Time reserveTime) {
		this.reserveTime = reserveTime;
	}
	
	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
