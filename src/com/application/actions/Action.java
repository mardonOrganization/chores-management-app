package com.application.actions;

import com.google.gson.JsonObject;

public interface Action {
	
	public Object execute(JsonObject params);

}
