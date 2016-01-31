package com.application.choresmanagement.entity;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class User implements EntityBuilder, Serializable, Comparable<User> {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("_id")
	private MongoObjectId idUser;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("lastname")
	private String lastname;
	
	@SerializedName("username")
	private String username;
	
//	@JsonAdapter(PasswordGsonAdapter.class)
	@SerializedName("password")
	private String password;
	
	@SerializedName("email")
	private String email;
	
//	@SerializedName("groupid")
//	private List<Group> myGroups;
	
	@SerializedName("groupid")
	private ArrayList<Integer> myGroups;
	
	// TODO manca qualcos'altro

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MongoObjectId getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser.setValue(idUser);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<Integer> getMyGroups() {
		return myGroups;
	}

	public void setMyGroups(ArrayList<Integer> myGroups) {
		this.myGroups = myGroups;
	}
	
	public void addGroupId(int groupId){
		this.myGroups.add(groupId);
	}
//	public List<Group> getMyGroups() {
//		return myGroups;
//	}
//	
//	public void setMyGroups(List<Group> myGroups) {
//		this.myGroups = myGroups;
//	}

	@Override
	public int compareTo(User another) {
		return idUser.getValue().compareTo(another.getIdUser().getValue());
	}
	
	private String GroupToString(){
		String array = "Group [";
		for(int i=0; i<myGroups.size()-1; i++){
			array += myGroups.get(i).toString() + ",";
		}	
		array += myGroups.get(myGroups.size()-1).toString();
		array += "]";
		return array;
	}
	
	@Override
	public String toString() {
		// TODO completare
		return "DocumentModel {"
				+ " name=" + name
				+ ", lastname=" + lastname
				+ ", email=" + email
				+ ", username=" + username
				+ ", groupid=" + GroupToString()
				+ "}";
	}

	@Override
	public void buildEntity() {
		// TODO Auto-generated method stub
		
	}

}
