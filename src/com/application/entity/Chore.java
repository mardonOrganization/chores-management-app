package com.application.entity;

import java.io.Serializable;

public class Chore implements EntityBuilder, Serializable {

	private static final long serialVersionUID = 1L;
	
	private enum Frequency {
		DAILY,
		WEEKLY,
		MONTHLY,
		YEARLY;
	}
	
	private String choreName; 
	
	private Frequency frequency;
	
	public String getChoreName() {
		return choreName;
	}

	public void setChoreName(String choreName) {
		this.choreName = choreName;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency periodicity) {
		this.frequency = periodicity;
	}

	@Override
	public void buildEntity() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public String toString() {
		// TODO completare
		return "Chore {"
				+ "choreName=" + choreName
				+ ", frequency=" + frequency
				+ "}";
	}

}
