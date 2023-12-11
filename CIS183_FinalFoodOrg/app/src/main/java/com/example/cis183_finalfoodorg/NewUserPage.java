package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewUserPage extends AppCompatActivity {
    ImageView btn_j_addUser_addUser;
    ImageView btn_j_addUser_home;
    EditText et_j_addUser_username;
    EditText et_j_addUser_password;

    Intent MainActivityIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_page);

        btn_j_addUser_addUser = (ImageView) findViewById(R.id.btn_v_addUserPage_addUser);
        btn_j_addUser_home = (ImageView) findViewById(R.id.btn_v_addUser_home);

        et_j_addUser_username = findViewById(R.id.et_v_addUserPage_username);
        et_j_addUser_password = findViewById(R.id.et_v_addUserPage_password);

        MainActivityIntent = new Intent(NewUserPage.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        ButtonEventHandler();



    }
    public void ButtonEventHandler()
    {
        btn_j_addUser_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!et_j_addUser_username.getText().toString().equals("") && !et_j_addUser_password.getText().toString().equals(""))
                {
                    if (dbHelper.addNewUser(et_j_addUser_username.getText().toString(), et_j_addUser_password.getText().toString()))
                    {
                        startActivity(MainActivityIntent);
                    }
                    else
                    {
                        Log.d("AddUser", "false");
                    }
                }
                else
                {
                    Log.d("Add User page", "Fields Not filled Out");
                }



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