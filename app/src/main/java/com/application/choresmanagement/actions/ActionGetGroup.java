package com.application.choresmanagement.actions;

import com.application.choresmanagement.entity.Group;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ActionGetGroup implements Action {

	@Override
	public Object execute(JsonObject params) {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		MongoLabImpl myMongoLab = MongoLabImpl.createInstance();
		
//		String hashResult = gson.toJson(params);
		JsonArray groupsJson = myMongoLab.queryDocuments("choresmanagement",
				"choregroup", params, Group.class);
		Group groupModel = new Group();
//		for (int i = 0; i < groupsJson.size(); i++) {
//			JsonObject groupJson = groupsJson.get(i).getAsJsonObject();
//			Log.d(TAG, "Document #" + (i + 1));
//			groupModel = (Group) gson.fromJson(groupJson, Group.class);
//			Log.d(TAG, groupModel.toString());
//		}
		
		if (groupsJson.size() > 0) {
			// only the first one
			JsonObject groupJson = groupsJson.get(0).getAsJsonObject();
			groupModel = (Group) gson.fromJson(groupJson, Group.class);
		}
		return groupModel;
	}

}
