package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditUser extends AppCompatActivity {
    Intent MainActivity;
    Intent HomePage;
    TextView tv_j_editUserPage_username;
    EditText et_j_editUserPage_password;
    ImageView btn_j_editUserPage_editUser;
    ImageView btn_j_editUserPage_home;
    ImageView btn_j_editUserPage_remove;
    DatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        btn_j_editUserPage_editUser = (ImageView) findViewById(R.id.btn_v_editUserPage_editUser);
        btn_j_editUserPage_home = (ImageView) findViewById(R.id.btn_v_editUserPage_home);
        btn_j_editUserPage_remove = (ImageView) findViewById(R.id.btn_v_editUserPage_remove);

        tv_j_editUserPage_username = findViewById(R.id.tv_v_editUser_username);
        et_j_editUserPage_password = findViewById(R.id.et_v_editUserPage_password);

        dbHelper = new DatabaseHelper(this);

        HomePage = new Intent(EditUser.this, HomePage.class);
        MainActivity = new Intent(EditUser.this, MainActivity.class);

        tv_j_editUserPage_username.setText(AppData.getUsername());



        et_j_editUserPage_password.setText(dbHelper.getPassword());

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
                dbHelper.updatePassword(et_j_editUserPage_password.getText().toString());

                startActivity(HomePage);
            }
        });
        btn_j_editUserPage_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteUser(tv_j_editUserPage_username.getText().toString());
                startActivity(MainActivity);
            }
        });
    }
}