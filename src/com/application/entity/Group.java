package com.application.entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Group implements EntityBuilder, Serializable {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("_id")
	private MongoObjectId idGroup;
	
	@SerializedName("name")	
	private String name;

	@SerializedName("noticeboard")
	private NoticeBoard noticeBoard;

	public String getIdGroup() {
		return idGroup.getValue();
	}

	public void setIdGroup(String idGroup) {
		this.idGroup.setValue(idGroup);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NoticeBoard getNoticeBoard() {
		return noticeBoard;
	}

	public void setNoticeBoard(NoticeBoard noticeBoard) {
		this.noticeBoard = noticeBoard;
	}

	@Override
	public void buildEntity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO completare
		return "Group {"
				+ " name=" + name
				+ " noticeboard=" + noticeBoard.toString()
				+ "}";
	}
	
}
