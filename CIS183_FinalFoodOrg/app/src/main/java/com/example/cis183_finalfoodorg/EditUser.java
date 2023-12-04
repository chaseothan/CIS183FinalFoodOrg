package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class EditUser extends AppCompatActivity {
    Intent MainActivity;
    Intent HomePage;
    EditText et_j_editUserPage_username;
    EditText et_j_editUserPage_password;
    ImageView btn_j_editUserPage_editUser;
    ImageView btn_j_editUserPage_home;
    ImageView btn_j_editUserPage_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        btn_j_editUserPage_editUser = (ImageView) findViewById(R.id.btn_v_editUserPage_editUser);
        btn_j_editUserPage_home = (ImageView) findViewById(R.id.btn_v_editUserPage_home);
        btn_j_editUserPage_remove = (ImageView) findViewById(R.id.btn_v_editUserPage_remove);

        et_j_editUserPage_username = findViewById(R.id.et_v_editUserPage_username);
        et_j_editUserPage_password = findViewById(R.id.et_v_editUserPage_password);

        HomePage = new Intent(EditUser.this, HomePage.class);
        MainActivity = new Intent(EditUser.this, MainActivity.class);

        ButtonEventHandler();

    }
    public void ButtonEventHandler()
    {
        btn_j_editUserPage_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        btn_j_editUserPage_editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        btn_j_editUserPage_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity);
            }
        });
    }
}