package com.application.choresmanagement.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.application.choresmanagement.R;
import com.application.choresmanagement.entity.User;
import com.application.choresmanagement.utils.Authentication;
import com.application.restfulclient.MongoLabImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegisterActivity extends AppCompatActivity {

    //mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

    private EditText name, surname, password, passwordAgain, username, email, birthDate;
    private Authentication authentication;
    private MongoLabImpl myMongoLab;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myMongoLab = MongoLabImpl.createInstance("1Eo97cO72-yUhHla_qn_eMRzFV1CdCr_");
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        authentication = new Authentication(myMongoLab, gson);

        name = (EditText) findViewById(R.id.editTextName);
        surname = (EditText) findViewById(R.id.editTextSurname);
        password = (EditText) findViewById(R.id.editTextPassword);
        passwordAgain = (EditText) findViewById(R.id.editTextRepeatPassword);
        username = (EditText) findViewById(R.id.editTextUsername);
        email = (EditText) findViewById(R.id.editTextEMail);
        birthDate = (EditText) findViewById(R.id.editTextBirthDate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
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

    public void onRegisterConfirmationClick(View v) {

        if (passwordAgain.getText().toString().equals(password.getText().toString())) {
            User user = authentication.checkIfUserExists(email.getText().toString());
            if (user == null) {
                user = authentication.saveUser(name.getText().toString(),
                        surname.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        username.getText().toString());
            } else {
                Toast.makeText(RegisterActivity.this, "Attenzione, esiste già un utente registrato con questo indirizzo e-mail", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "Attenzione, i campi 'Password' devono contenere lo stesso valore", Toast.LENGTH_SHORT).show();
        }
    }
}
