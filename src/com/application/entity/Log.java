package com.application.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Log implements EntityBuilder, Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("user")
	private User user; // utente che ha registrato il check-in della faccenda
	
	@SerializedName("date")
	private Date date; // data in cui è stato registrato il check-in della faccenda
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public void buildEntity() {
		// TODO Auto-generated method stub
	}
	

}
