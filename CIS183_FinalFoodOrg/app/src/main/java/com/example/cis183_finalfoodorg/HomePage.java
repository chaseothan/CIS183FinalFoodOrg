package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.security.identity.CipherSuiteNotSupportedException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {


    Intent TotalListIntent;
    Intent PlaceListIntent;
    Intent EditUser;
    Intent Use;
    Intent AddItem;
    ImageView btn_j_homePage_add;
    ImageView btn_j_homePage_use;
    ImageView btn_j_homePage_editUser;
    ImageView btn_j_homePage_list;
    ImageView btn_j_homePage_place;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TotalListIntent = new Intent(HomePage.this, TotalList.class);
        PlaceListIntent = new Intent(HomePage.this, PlaceList.class);
        EditUser = new Intent(HomePage.this, EditUser.class);
        Use = new Intent(HomePage.this, Use.class);
        AddItem = new Intent(HomePage.this, AddItem.class);


        btn_j_homePage_add = (ImageView) findViewById(R.id.btn_v_homePage_add);
        btn_j_homePage_use = (ImageView) findViewById(R.id.btn_v_homePage_use);
        btn_j_homePage_editUser = (ImageView) findViewById(R.id.btn_v_homePage_editUser);
        btn_j_homePage_list = (ImageView) findViewById(R.id.btn_v_homePage_list);
        btn_j_homePage_place = (ImageView) findViewById(R.id.btn_v_homePage_place);

        ButtonClickEventHandler();
    }

    public void ButtonClickEventHandler()
    {
        btn_j_homePage_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddItem);
            }
        });
        btn_j_homePage_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Use);
            }
        });
        btn_j_homePage_editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditUser);
            }
        });
        btn_j_homePage_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TotalListIntent);
            }
        });
        btn_j_homePage_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PlaceListIntent);
            }
        });


    }



}