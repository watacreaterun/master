package com.example.demo.model;

public class ReservationForm {
	
	private int Id;
	private String reserveDate;
	private String reserveTime;
	private int reserveNum;
	private String customerName;
	private String email;
	private String phone;
	private String comment;
	
	/*	
		getter
	*/
	public int getId() {
		return Id;
	}
	
	public String getReserveDate() {
		return reserveDate;
	}
	
	public String getReserveTime() {
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

	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	public void setReserveTime(String reserveTime) {
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