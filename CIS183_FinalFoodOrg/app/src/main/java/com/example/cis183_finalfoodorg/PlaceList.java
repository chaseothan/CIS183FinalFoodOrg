package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceList extends AppCompatActivity {
    Intent totalList;
    Intent addPlace;
    Intent HomePage;
    ListView lv_j_placeList_listOfPlaces;
    ImageView btn_j_placeList_home;
    ImageView btn_j_placeList_totalList;
    ImageView btn_j_placeList_addPlace;
    PlaceListAdapter adapter;
    ArrayList<Place> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        btn_j_placeList_totalList = (ImageView) findViewById(R.id.btn_v_placeList_list);
        btn_j_placeList_addPlace = (ImageView) findViewById(R.id.btn_v_placeList_addPlace);
        btn_j_placeList_home = (ImageView) findViewById(R.id.btn_v_placeList_home);

        lv_j_placeList_listOfPlaces = findViewById(R.id.lv_v_placeList_listOfPlaces);

        totalList = new Intent(PlaceList.this, TotalList.class);
        addPlace = new Intent(PlaceList.this, AddPlace.class);
        HomePage = new Intent(PlaceList.this, HomePage.class);

        placeList = new ArrayList<Place>();

        ButtonEventHandler();
        fillListView();
    }

    public void ButtonEventHandler()
    {
        btn_j_placeList_totalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(totalList);
            }
        });
        btn_j_placeList_addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addPlace);
            }
        });
        btn_j_placeList_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
    }
    public void fillListView()
    {
        adapter = new PlaceListAdapter(this, placeList);
        lv_j_placeList_listOfPlaces.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}