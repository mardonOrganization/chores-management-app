package com.application.choresmanagement.activity;

import com.application.restfulclient.MongoLabImpl;
import com.google.gson.JsonObject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marco.suma on 07/02/2016.
 */
public class MainActivityTest {

    @Test
    public void testName() throws Exception {
// Delete multiple documents
        // Json object representing the query
        MongoLabImpl myMongoLab = MongoLabImpl.createInstance();
        JsonObject queryDelete = new JsonObject();
        myMongoLab.deleteDocuments("choresmanagement", "user", queryDelete);

//        JsonObject jsonDeleteResult = myMongoLab.deleteDocument("choresmanagement", "choregroup", groupModel.getIdGroup());
//        JsonObject documentDeleteJson = jsonDeleteResult;
//        Log.d(TAG, "Document");
//        DocumentModel documentDeleteModel = (DocumentModel) gson.fromJson(documentDeleteJson, DocumentModel.class);
//        Log.d(TAG, documentDeleteModel.toString());

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
}