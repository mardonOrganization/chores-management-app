package com.application.choresmanagement.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NoticeBoard extends HashMap<Chore, ArrayList<ChoreLog>> implements Serializable{

	private static final long serialVersionUID = 1L;
//	@SerializedName("choresboard")
//	private HashMap<Chore, ArrayList<ChoreLog>> choresBoard;
	
//	@SerializedName("chorelog")
//	private ArrayList<ChoreLog> choreLog;
//
//	public ArrayList<ChoreLog> getChoreLog() {
//		return choreLog;
//	}
//
//	public void setChoreLog(ArrayList<ChoreLog> choreLog) {
//		this.choreLog = choreLog;
//	}
	
//	public Set<Entry<Chore, ArrayList<ChoreLog>>> entrySet() {
//		return choresBoard.entrySet();
//	}
//
//
//	public NoticeBoard(){
//		choresBoard = new HashMap<>();
//	}
//
//	public ArrayList<ChoreLog> put(Chore key, ArrayList<ChoreLog> value) {
//		return choresBoard.put(key, value);
//	}
//
//	public ArrayList<ChoreLog> get(Object key) {
//		return choresBoard.get(key);
//	}
//
//	private String choreLogToString(ArrayList<ChoreLog> choreLog){
//		String result = "[";
//		for(int i=0; i<choreLog.size(); i++){
//			result += choreLog.get(i).toString();
//			// Not inserting the comma for the last iteration
//			result += i!=choreLog.size()-1? "," : "";
//		}
//		result += "]";
//		return result;
//	}

	
//	@Override
//	public String toString() {
//		// TODO completare
//		String result = "NoticeBoard {";
//		Set<Chore> keys = choresBoard.keySet();
//
//		// Loop over String keys.
//		for (Chore key : keys) {
//			result += "[";
//			result += key.toString() + ",";
//			result += choreLogToString(choresBoard.get(key));
//			result += "]";
//		}
//		result += "}";
//		return result;
//	}
	


}
