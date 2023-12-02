package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {


    Intent TotalListIntent;
    Intent PlaceListIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TotalListIntent = new Intent(HomePage.this, TotalList.class);
        PlaceListIntent = new Intent(HomePage.this, PlaceList.class);

        ButtonClickEventHandler();
    }

    public void ButtonClickEventHandler()
    {



    }



}