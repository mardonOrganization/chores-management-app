package com.application.actions;

import com.google.gson.JsonObject;

public interface Action {
	
	/** 
	 * 
	 * @param params let's see if we have conflincts
	 * @return
	 */
	public Object execute(JsonObject params);

}
