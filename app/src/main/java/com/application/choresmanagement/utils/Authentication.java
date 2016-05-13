package com.application.choresmanagement.utils;

import android.util.Log;

import com.application.choresmanagement.entity.User;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by marco.suma on 01/02/2016.
 */
public class Authentication {

    private MongoLabImpl myMongoLab;
    private Gson gson;

    public Authentication(MongoLabImpl m, Gson g) {
        myMongoLab = m;
        gson = g;
    }

    /**
     * @param email
     * @return an instance of User if it exists on DB, otherwise null
     */
    public User checkIfUserExists(String email) {
        return checkIfUserExists(email, null);
    }

    /**
     * @param email
     * @param password
     * @return an instance of User if it exists on DB, otherwise null
     */
    public User checkIfUserExists(String email, String password) {
        // Fetching user object
        JsonObject query = new JsonObject();
        query.addProperty("email", email);
        if (password != null) {
            query.addProperty("password", password);
        }
        //		String result = gson.toJson(query);
        JsonArray usersJson = myMongoLab.queryDocuments("chores-management",
                "user", query, User.class);
        User userModel = new User();
        if (usersJson != null && usersJson.size() == 1) {
            JsonObject userJson = usersJson.get(0).getAsJsonObject();
            userModel = gson.fromJson(userJson, User.class);
            //Log.d(TAG, userModel.toString());
            return userModel;
        }
        return null;
    }

    public User saveUser(String name, String lastname, String email, String password, String username) {
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        JsonObject jsonObjectResult =
                myMongoLab.insertDocument("chores-management", "user", user);
        JsonObject documentObjectJson = jsonObjectResult;
        User documentObjectModel = gson.fromJson(documentObjectJson, User.class);
        return documentObjectModel;
    }

}
