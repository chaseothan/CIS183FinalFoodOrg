package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_j_main_totalList;
    Button btn_j_main_placeList;

    Intent TotalListIntent;
    Intent PlaceListIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_j_main_totalList = findViewById(R.id.btn_v_main_totalList);
        btn_j_main_placeList = findViewById(R.id.btn_v_main_placeList);


        TotalListIntent = new Intent(MainActivity.this, TotalList.class);
        PlaceListIntent = new Intent(MainActivity.this, PlaceList.class);

        ButtonClickEventHandler();
    }

    public void ButtonClickEventHandler()
    {

        btn_j_main_totalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                startActivity(TotalListIntent);

            }
        });

        btn_j_main_placeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(PlaceListIntent);
            }
        });


    }



}