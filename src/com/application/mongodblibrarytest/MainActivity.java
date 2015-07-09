package com.application.mongodblibrarytest;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.application.entity.ChoreLog;
import com.application.entity.Group;
import com.application.entity.NoticeBoard;
import com.application.entity.User;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MainActivity extends Activity {

	public static String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		MongoLabImpl myMongoLab = MongoLabImpl.createInstance();
		// List all databases
		// JsonArray jsonResult = myMongoLab.listDatabases();
		//
		// for (int i = 0; i < jsonResult.size(); i++) {
		// String database = jsonResult.get(i).getAsString();
		// Log.d(TAG, "Database #" + (i + 1) + ": " + database);
		// }
		//
		// // List all collections associated to a database
		// jsonResult = myMongoLab.listCollections("choresmanagement");
		//
		// for (int i = 0; i < jsonResult.size(); i++) {
		// String collection = jsonResult.get(i).getAsString();
		// Log.d(TAG, "Collection #" + (i + 1) + ": " + collection);
		// }

		// List all documents in a collection
		JsonArray jsonResult = myMongoLab.listDocuments("choresmanagement",
				"user");

		for (int i = 0; i < jsonResult.size(); i++) {
			JsonObject document = jsonResult.get(i).getAsJsonObject();
			Log.d(TAG, "Document #" + (i + 1));
			User documentModel = (User) gson.fromJson(document, User.class);
			Log.d(TAG, documentModel.toString());
		}

//		 Insert Single document
//		 Serializing the document object into a Json String
//		 ArrayList<Integer> groupIds = new ArrayList();
//		 groupIds.add(4);
//		 groupIds.add(5);
//		 groupIds.add(6);
//		 User user = new User();
//		 user.setName("Donato");
//		 user.setLastname("Barone");
//		 user.setEmail("eng.donato.barone@gmail.com");
//		 user.setPassword("asda12asd3favftqcbrin3Q3WE3EQQ132asdijjiaaa14");
//		 user.setUsername("donatobarone");
//		 user.setMyGroups(groupIds);
//		 JsonObject jsonObjectResult =
//		 myMongoLab.insertDocument("choresmanagement", "user", user);
//		 JsonObject documentObjectJson = jsonObjectResult;
//		 Log.d(TAG, "Document inserted");
//		 User documentObjectModel = (User) gson.fromJson(documentObjectJson,
//		 User.class);
//		 Log.d(TAG, documentObjectModel.toString());

		// Adding ID to the groupid list
		// user.addGroupId(7);
		// JsonObject object = new JsonObject();
		// JsonElement element = gson.toJsonTree(user.getMyGroups(), new
		// TypeToken<ArrayList<Integer>>() {}.getType());
		// object.add("groupid", element);
		// JsonObject jsonObjectResult =
		// myMongoLab.updateDocument("choresmanagement", "user",
		// "55848fe1e4b0a968dfecf040", object);

		// Fetching user object
		JsonObject query = new JsonObject();
		query.addProperty("lastname", "Barone");
//		String result = gson.toJson(query);
		JsonArray usersJson = myMongoLab.queryDocuments("choresmanagement",
				"user", query, User.class);
		User userModel = new User();
		for (int i = 0; i < usersJson.size(); i++) {
			JsonObject userJson = usersJson.get(i).getAsJsonObject();
			Log.d(TAG, "Document #" + (i + 1));
			userModel = (User) gson.fromJson(userJson, User.class);
			Log.d(TAG, userModel.toString());
		}

		// Inserting a group id
//		Group group = new Group();
//		group.setName("MarcoDonatoChores");
//		Chore chore = new Chore();
//		chore.setChoreName("Cleaning bathroom");
//		chore.setStartTimeStamp(new Date());
//		chore.setPickedUpBy(userModel);
//		
//		ChoreProcessing choreProcessing = new ChoreProcessing();
//		choreProcessing.setItsMyTurn(false);
//		choreProcessing.setDelayed(false);
//		choreProcessing.setTurnCompleted(true);
//		
//		NoticeBoard noticeBoard = new NoticeBoard();
//		noticeBoard.put(chore, "Donato");
//		
//		group.setNoticeBoard(noticeBoard);
//
//		String post = gson.toJson(group);
//		myMongoLab.insertDocument("choresmanagement", "choregroup", group);
//
		
//		 // Delete multiple documents
//		 // Json object representing the query
//		 JsonObject queryDelete = new JsonObject();
//		 queryDelete.addProperty("name", "MarcoDonatoChores");
//		 myMongoLab.deleteDocuments("choresmanagement", "choregroup", queryDelete);
		
//		JsonObject jsonDeleteResult = myMongoLab.deleteDocument("choresmanagement", "choregroup", groupModel.getIdGroup());
//		JsonObject documentDeleteJson = jsonDeleteResult;
//		Log.d(TAG, "Document");
//		DocumentModel documentDeleteModel = (DocumentModel) gson.fromJson(documentDeleteJson, DocumentModel.class);
//		Log.d(TAG, documentDeleteModel.toString());
		
		
//		
		/////NEW VERSION WITH ARRAYLIST<CHORELOG> AS VALUE FOR THE HASHMAP
//		Group group = new Group();
//		group.setName("MarcoDonatoChores");
//		Chore chore = new Chore();
//		chore.setChoreName("Cleaning bathroom");
//
//		NoticeBoard noticeBoard = new NoticeBoard();
//
//		ChoreLog log = new ChoreLog();
//		log.setDate(new Date());
//		log.setUser(userModel);
//		ArrayList<ChoreLog> list = new ArrayList<ChoreLog>();	
//		list.add(log);
//
//		noticeBoard.put(chore, list);
//		group.setNoticeBoard(noticeBoard);
//
//		String post = gson.toJson(group);
//		myMongoLab.insertDocument("choresmanagement", "choregroup", group);
////	
//		// Fetching Hash Map object
		JsonObject hashQuery = new JsonObject();
		hashQuery.addProperty("name", "MarcoDonatoChores");
		JsonArray groupsJson = myMongoLab.queryDocuments("choresmanagement",
				"choregroup", hashQuery, Group.class);
		Group groupModel = new Group();
		for (int i = 0; i < groupsJson.size(); i++) {
			JsonObject groupJson = groupsJson.get(i).getAsJsonObject();
			Log.d(TAG, "Document #" + (i + 1));
			groupModel = (Group) gson.fromJson(groupJson, Group.class);
			Log.d(TAG, groupModel.toString());
		}
		
		
//		 Update multiple documents
//		 Json object representing the new value to set in the document
//		 JsonObject update = new JsonObject();
//		 NoticeBoard noticeBoard = groupModel.getNoticeBoard();
//		 Chore newChore = new Chore();
//		 newChore.setChoreName("Shopping groceries");
//		 ArrayList<ChoreLog> newList = new ArrayList<ChoreLog>();
//		 noticeBoard.put(newChore, newList);
//		 JsonElement element = gson.toJsonTree(noticeBoard, NoticeBoard.class);
//		 update.add("noticeboard", element);
//		 JsonObject jsonUpdateResult = myMongoLab.updateDocument(
//				 	"choresmanagement", "choregroup", groupModel.getIdGroup(), update);
//		 JsonObject documentUpdateJson = jsonUpdateResult;
//		 Log.d(TAG, "Document");
//		 groupModel = (Group) gson.fromJson(documentUpdateJson, Group.class);
//		 Log.d(TAG, groupModel.toString());
		
		// update log
		JsonObject update = new JsonObject();
		NoticeBoard noticeBoard = groupModel.getNoticeBoard();
		ArrayList<ChoreLog> list = noticeBoard.entrySet().iterator().next().getValue();
		ChoreLog log = new ChoreLog();
		log.setDate(new Date());
		log.setUser(userModel);
		list.add(log);
		JsonElement element = gson.toJsonTree(noticeBoard, NoticeBoard.class);
		// update.addProperty("lastname", "Rossi");
		update.add("noticeboard", element);
		JsonObject jsonUpdateResult = myMongoLab.updateDocument("choresmanagement", "choregroup", groupModel.getIdGroup(), update);
		JsonObject documentUpdateJson = jsonUpdateResult;
		Log.d(TAG, "Document");
		groupModel = (Group) gson.fromJson(documentUpdateJson, Group.class);
		Log.d(TAG, groupModel.toString());

		// // Insert Multiple documents
		// List<Integer> groupid_first = Arrays.asList(1, 2, 3);
		// DocumentModel document_first = new DocumentModel("Marco", "Suma",
		// groupid_first);
		// //
		// List<Integer> groupid_second = Arrays.asList(1, 2, 3);
		// DocumentModel document_second = new DocumentModel("Michele",
		// "Barone",
		// groupid_second);
		// //
		// List<Object> documents = new ArrayList<Object>();
		// documents.add(document_first);
		// documents.add(document_second);
		// myMongoLab.insertDocuments("choresmanagement", "user",
		// documents);
		//
		// //
		// //
		// // Query on the database
		// JsonObject query = new JsonObject();
		// query.addProperty("lastname", "Suma");
		// jsonResult = myMongoLab.queryDocuments("choresmanagement", "user",
		// query, DocumentModel.class);
		//
		// for (int i = 0; i < jsonResult.size(); i++) {
		// JsonObject documentJson = jsonResult.get(i).getAsJsonObject();
		// Log.d(TAG, "Document #" + (i + 1));
		// DocumentModel documentModel = (DocumentModel) gson
		// .fromJson(documentJson, DocumentModel.class);
		// Log.d(TAG, documentModel.toString());
		// }


		// JsonObject jsonDeleteResult = myMongoLab.deleteDocument(
		// "choresmanagement", "user", "557ca090e4b06f39cd63beaa");
		// JsonObject documentDeleteJson = jsonDeleteResult;
		// Log.d(TAG, "Document");
		// DocumentModel documentDeleteModel = (DocumentModel) gson.fromJson(
		// documentDeleteJson, DocumentModel.class);
		// Log.d(TAG, documentDeleteModel.toString());
		//
		// // Delete multiple documents
		// // Json object representing the query
		// JsonObject queryDelete = new JsonObject();
		// queryDelete.addProperty("lastname", "con custom adapters");
		// myMongoLab.deleteDocuments("choresmanagement", "user", queryDelete);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
