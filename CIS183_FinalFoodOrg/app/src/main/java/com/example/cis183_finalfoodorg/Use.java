package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Use extends AppCompatActivity {
    Intent homePage;
    ImageView btn_j_usePage_home;
    ImageView btn_j_usePage_use;
    EditText et_j_usePage_product;
    EditText et_j_usePage_expDate;
    EditText et_j_usePage_amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use);
        btn_j_usePage_home = (ImageView) findViewById(R.id.btn_v_usePage_home);
        btn_j_usePage_use = (ImageView) findViewById(R.id.btn_v_usePage_use);

        et_j_usePage_product = findViewById(R.id.et_v_usePage_product);
        et_j_usePage_expDate = findViewById(R.id.et_v_usePage_expDate);
        et_j_usePage_amount = findViewById(R.id.et_v_usePage_amount);

        homePage = new Intent(Use.this, HomePage.class);

        EventHandlerClickButton();
    }

    public void EventHandlerClickButton()
    {
        btn_j_usePage_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homePage);
            }
        });
        btn_j_usePage_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use the item
            }
        });
    }
}