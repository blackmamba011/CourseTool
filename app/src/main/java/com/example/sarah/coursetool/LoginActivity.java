package com.example.sarah.coursetool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

/*    Button loginButton = (Button)findViewById(R.id.login_button);
    EditText username = (EditText)findViewById(R.id.username);
    EditText password = (EditText)findViewById(R.id.password);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    /*Called when login button is pressed*/
    public void processLogin(View view){
        /*if(username.toString().equals("admin") && password.toString().equals("admin")){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }*/
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
