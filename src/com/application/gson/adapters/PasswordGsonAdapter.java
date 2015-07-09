package com.application.gson.adapters;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class PasswordGsonAdapter extends TypeAdapter<String>{

	@Override
	public String read(JsonReader in) throws IOException {
		in.beginObject();
	    in.nextName();
	    String password = in.nextString();
	    in.endObject();
	    return password;
	}

	@Override
	public void write(JsonWriter out, String password) throws IOException {
	     out.beginObject();
	     out.name("password");
	     out.value(password);
	     out.endObject();
	}


}
