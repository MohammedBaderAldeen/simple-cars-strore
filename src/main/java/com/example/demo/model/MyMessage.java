package com.example.demo.model;

import java.util.Date;

public class MyMessage {

	private String email;

	private Cars data;

	private Date DateMessage;

	public MyMessage() {
		
	}
	public MyMessage(String email, Cars data, Date datemessage) {
		super();
		this.email = email;
		this.data = data;
		this.DateMessage = datemessage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cars getData() {
		return data;
	}

	public void setData(Cars data) {
		this.data = data;
	}
	
	
	public Date getDateMessage() {
		return DateMessage;
	}
	
	public void setDateMessage(Date dateMessage) {
		DateMessage = dateMessage;
	}

	

}
