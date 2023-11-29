package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewUserPage extends AppCompatActivity {
    Button btn_j_newUser_change;

    Intent MainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_page);

        btn_j_newUser_change = findViewById(R.id.btn_v_newUseer_change);

        MainActivityIntent = new Intent(NewUserPage.this, MainActivity.class);


        ButtonEventHandler();



    }
    public void ButtonEventHandler()
    {
        btn_j_newUser_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivityIntent);
            }
        });
    }
}