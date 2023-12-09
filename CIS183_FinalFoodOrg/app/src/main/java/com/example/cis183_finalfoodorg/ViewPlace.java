package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPlace extends AppCompatActivity {
    Intent PlaceList;
    Intent TotalList;
    Intent HomePage;
    Intent EditPlace;
    TextView tv_j_viewPlace_titleOfPlace;
    ListView lv_j_viewPlace_listOfItems;
    ImageView btn_j_viewPlace_remove;
    ImageView btn_j_viewPlace_home;
    ImageView btn_j_viewPlace_list;
    ImageView btn_j_viewPlace_editPlace;
    Place placePassed;
    DatabaseHelper dbHelper;
    TotalListAdapter adapter;
    ArrayList<Item> placeListOfItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place);



        btn_j_viewPlace_remove = (ImageView) findViewById(R.id.btn_v_viewPlace_remove);
        btn_j_viewPlace_editPlace = (ImageView) findViewById(R.id.btn_v_viewPlace_editPlace);
        btn_j_viewPlace_list = (ImageView) findViewById(R.id.btn_v_viewPlace_list);
        btn_j_viewPlace_home = (ImageView) findViewById(R.id.btn_v_viewPlace_home);

        Intent cameFrom = getIntent();


        placePassed = (Place) cameFrom.getSerializableExtra("Place");
        Log.d("ViewPlace", "extras");
        //  find all records based on the placeId
        //  and fill PlaceListOfItems
        placeListOfItems = new ArrayList<Item>();
        Log.d("ViewPlace", "item");

        dbHelper = new DatabaseHelper(this);
        Log.d("ViewPlace", "db");
        int id = placePassed.getPlaceId();
        Log.d("ViewPlace", "Id");
        Log.d("Id = ", id + " ");

        Log.d("ViewPlace", "Get all items by place");
        placeListOfItems = dbHelper.getAllItemsByPlace(id);
        Log.d("ViewPlace", "Did it ^");

        lv_j_viewPlace_listOfItems = findViewById(R.id.lv_v_viewPlace_listOfItems);

        tv_j_viewPlace_titleOfPlace = findViewById(R.id.tv_v_viewPlace_place);

        PlaceList = new Intent(ViewPlace.this, PlaceList.class);
        TotalList = new Intent(ViewPlace.this, TotalList.class);
        EditPlace = new Intent(ViewPlace.this, EditPlace.class);
        HomePage = new Intent(ViewPlace.this, HomePage.class);

        ButtonEventHandler();
        fillListView();

    }
    public void ButtonEventHandler()
    {
        btn_j_viewPlace_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PlaceList);
            }
        });
        btn_j_viewPlace_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TotalList);
            }
        });
        btn_j_viewPlace_editPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditPlace);
            }
        });
        btn_j_viewPlace_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
    }

    public void fillListView()
    {

        Log.d("getAllItems", "Return");
        adapter = new TotalListAdapter(this, placeListOfItems);
        lv_j_viewPlace_listOfItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}