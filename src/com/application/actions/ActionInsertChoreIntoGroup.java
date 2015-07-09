package com.application.actions;

import java.util.ArrayList;

import com.application.entity.Chore;
import com.application.entity.Group;
import com.application.entity.Log;
import com.application.entity.NoticeBoard;
import com.application.mongodblibrarytest.MainActivity;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ActionInsertChoreIntoGroup {
	
	public static String TAG = MainActivity.class.getSimpleName();

	public Object execute(Group myGroup, Chore chore) {	
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		MongoLabImpl myMongoLab = MongoLabImpl.createInstance();
		
		NoticeBoard noticeBoard = myGroup.getNoticeBoard();
		ArrayList<Log> logs = new ArrayList<Log>();
		noticeBoard.put(chore, logs);
//		String documentJson = gson.toJson(noticeBoard);
		JsonElement value = gson.toJsonTree(noticeBoard, NoticeBoard.class);
		JsonObject update = new JsonObject();
		update.add("noticeBoard", value);
//		update.addProperty("noticeBoard", documentJson);
		JsonObject documentUpdateJson = myMongoLab.updateDocument("choresmanagement", "choregroup", myGroup.getIdGroup() , update);
		android.util.Log.d(TAG, "Document");
		myGroup = (Group) gson.fromJson(documentUpdateJson, Group.class);
		android.util.Log.d(TAG, myGroup.toString());
		
		return myGroup;
	}

}
