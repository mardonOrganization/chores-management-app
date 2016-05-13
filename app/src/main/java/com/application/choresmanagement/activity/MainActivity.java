package com.application.choresmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AndroidException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.application.choresmanagement.CustomListViewAndroidExample;
import com.application.choresmanagement.R;
import com.application.choresmanagement.entity.Group;
import com.application.choresmanagement.entity.MongoObjectId;
import com.application.choresmanagement.entity.NoticeBoard;
import com.application.choresmanagement.entity.User;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Toolbar mToolbar;
    private User mUser;
    private List<Group> mUserGroups;
    private Group mActiveGroup;
    private MongoLabImpl myMongoLab;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        myMongoLab = MongoLabImpl.createInstance("1Eo97cO72-yUhHla_qn_eMRzFV1CdCr_");
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        Bundle extras = getIntent() != null ? getIntent().getExtras() : null;
        if (extras != null) {
            mUser = (User) extras.get(LoginActivity.USER);
            mUserGroups = new ArrayList<>();
            ArrayList<Group> groups = mUser.getMyGroups();

            for (Group group : groups) {
                JsonObject hashQuery = new JsonObject();
                MongoObjectId id = new MongoObjectId();
                id.setValue(String.valueOf(group.getIdGroup()));
                hashQuery.addProperty("_id", gson.toJson(id));
                JsonArray groupsJson = myMongoLab.queryDocuments("choresmanagement",
                        "choregroup", hashQuery, Group.class);
                Group groupModel;
                for (int i = 0; i < groupsJson.size(); i++) {
                    JsonObject groupJson = groupsJson.get(i).getAsJsonObject();
                    Log.d(TAG, "Document #" + (i + 1));
                    groupModel = (Group) gson.fromJson(groupJson, Group.class);
                    mUserGroups.add(groupModel);
                    Log.d(TAG, groupModel.toString());
                }
            }

            // by default, the group selected is the first one
            // TODO handle persistent data on device, which will contains, among the others, the info about the last active group
            if (groups.size() > 0) {
                mActiveGroup = groups.get(0);
            }
        }

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onButtonClicked(View v) {
        Intent intent = new Intent(this, CustomListViewAndroidExample.class);

        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Group addNewGroupToConnectedUser(Group group) {
		JsonObject result = myMongoLab.insertDocument("choresmanagement", "choregroup", group);
        Group groupCreated = (Group) gson.fromJson(result, Group.class);
        List<Group> groups = mUser.getMyGroups();
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(groupCreated);
        return groupCreated;
    }

    private Boolean changeGroupSelected(int selected) {
        try {
            mActiveGroup = mUserGroups.get(selected);
            return Boolean.TRUE;
        } catch (IndexOutOfBoundsException iobe) {
            iobe.printStackTrace();
            return Boolean.FALSE;
        }

    }

    private NoticeBoard getChoresActiveGroup() {
        if (mActiveGroup != null) {
            return mActiveGroup.getNoticeBoard();
        }
        return null;
    }

}
