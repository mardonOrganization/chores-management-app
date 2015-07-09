package com.application.actions;

import com.google.gson.JsonObject;

public interface Action {
	
	/** 
	 * 
	 * @param params
	 * @return
	 */
	public Object execute(JsonObject params);

}
