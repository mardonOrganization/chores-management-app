package com.application.entity;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class MongoObjectId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("$oid")
	private String value;
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		// TODO completare
		return "MongoObjectId {"
				+ " id=" + this.value
				+ "}";
	}
}
