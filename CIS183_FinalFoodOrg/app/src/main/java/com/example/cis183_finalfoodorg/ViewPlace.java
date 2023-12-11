package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPlace extends AppCompatActivity {
    Intent PlaceList;
    Intent TotalList;
    Intent HomePage;
    Intent EditPlace;
    Intent ProductProfile;
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
        //  find all records based on the placeId
        //  and fill PlaceListOfItems
        placeListOfItems = new ArrayList<Item>();

        dbHelper = new DatabaseHelper(this);
        int id = placePassed.getPlaceId();

        placeListOfItems = dbHelper.getAllItemsByPlace(id);

        lv_j_viewPlace_listOfItems = findViewById(R.id.lv_v_viewPlace_listOfItems);

        tv_j_viewPlace_titleOfPlace = findViewById(R.id.tv_v_viewPlace_place);

        tv_j_viewPlace_titleOfPlace.setText(placePassed.getPlace());



        PlaceList = new Intent(ViewPlace.this, PlaceList.class);
        TotalList = new Intent(ViewPlace.this, TotalList.class);
        EditPlace = new Intent(ViewPlace.this, EditPlace.class);
        HomePage = new Intent(ViewPlace.this, HomePage.class);
        ProductProfile = new Intent(ViewPlace.this, ProductProfile.class);

        ButtonEventHandler();
        fillListView();

    }
    public void ButtonEventHandler()
    {
        btn_j_viewPlace_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deletePlace(placePassed);
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
                EditPlace.putExtra("Place", placePassed);


                startActivity(EditPlace);
            }
        });
        btn_j_viewPlace_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        lv_j_viewPlace_listOfItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ProductProfile.putExtra("Item", placeListOfItems.get(position));

                startActivity(ProductProfile);
            }
        });


    }

    public void fillListView()
    {

        adapter = new TotalListAdapter(this, placeListOfItems);
        lv_j_viewPlace_listOfItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}