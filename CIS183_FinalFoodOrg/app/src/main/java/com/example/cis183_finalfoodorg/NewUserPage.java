package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewUserPage extends AppCompatActivity {
    ImageView btn_j_addUser_change;
    ImageView btn_j_addUser_home;
    EditText et_j_addUser_username;
    EditText et_j_addUser_password;

    Intent MainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_page);

        btn_j_addUser_change = (ImageView) findViewById(R.id.btn_v_addUserPage_addUser);
        btn_j_addUser_home = (ImageView) findViewById(R.id.btn_v_addUser_home);

        et_j_addUser_username = findViewById(R.id.et_v_addUserPage_username);
        et_j_addUser_password = findViewById(R.id.et_v_addUserPage_password);

        MainActivityIntent = new Intent(NewUserPage.this, MainActivity.class);


        ButtonEventHandler();



    }
    public void ButtonEventHandler()
    {
        btn_j_addUser_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivityIntent);
            }
        });
        btn_j_addUser_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivityIntent);
            }
        });
    }
}