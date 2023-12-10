package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddPlace extends AppCompatActivity {
    Intent PlaceList;
    Intent HomePage;
    EditText et_j_addPlace_place;
    ImageView btn_j_addPlace_addPlace;
    ImageView btn_j_addPlace_home;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);

        et_j_addPlace_place = findViewById(R.id.et_v_addPlace_nameOfPlace);

        btn_j_addPlace_addPlace = (ImageView) findViewById(R.id.btn_v_addPlace_addPlace);
        btn_j_addPlace_home = (ImageView) findViewById(R.id.btn_v_addPlace_home);

        PlaceList = new Intent(AddPlace.this, TotalList.class);
        HomePage = new Intent(AddPlace.this, HomePage.class);

        dbHelper = new DatabaseHelper(this);



        ButtonEventHandler();
    }
    public void ButtonEventHandler()
    {
        btn_j_addPlace_addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PlaceList);
                dbHelper.addNewPlace(et_j_addPlace_place.getText().toString());
            }

        });
        btn_j_addPlace_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
    }
}