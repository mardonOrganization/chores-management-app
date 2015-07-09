package com.application.entity;

public class ChoreProcessing {
	
	private Boolean turnCompleted;
	private Boolean itsMyTurn;
	private Boolean delayed;
	
	public Boolean getDelayed() {
		return delayed;
	}
	public void setDelayed(Boolean delayed) {
		this.delayed = delayed;
	}
	public Boolean getItsMyTurn() {
		return itsMyTurn;
	}
	public void setItsMyTurn(Boolean itsMyTurn) {
		this.itsMyTurn = itsMyTurn;
	}
	public Boolean getTurnCompleted() {
		return turnCompleted;
	}
	public void setTurnCompleted(Boolean turnCompleted) {
		this.turnCompleted = turnCompleted;
	} 

}
