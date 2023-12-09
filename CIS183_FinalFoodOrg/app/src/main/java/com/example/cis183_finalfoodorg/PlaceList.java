package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceList extends AppCompatActivity {
    Intent totalList;
    Intent addPlace;
    Intent HomePage;
    Intent viewPlace;
    ListView lv_j_placeList_listOfPlaces;
    ImageView btn_j_placeList_home;
    ImageView btn_j_placeList_totalList;
    ImageView btn_j_placeList_addPlace;
    PlaceListAdapter adapter;
    ArrayList<Place> placeList;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        dbHelper = new DatabaseHelper(this);

        btn_j_placeList_totalList = (ImageView) findViewById(R.id.btn_v_placeList_list);
        btn_j_placeList_addPlace = (ImageView) findViewById(R.id.btn_v_placeList_addPlace);
        btn_j_placeList_home = (ImageView) findViewById(R.id.btn_v_placeList_home);

        lv_j_placeList_listOfPlaces = findViewById(R.id.lv_v_placeList_listOfPlaces);

        totalList = new Intent(PlaceList.this, TotalList.class);
        addPlace = new Intent(PlaceList.this, AddPlace.class);
        HomePage = new Intent(PlaceList.this, HomePage.class);
        viewPlace = new Intent(PlaceList.this, ViewPlace.class);

        placeList = new ArrayList<Place>();

        placeList = dbHelper.getAllPlaces();
        Log.d("PlaceList", "got all places");

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

        lv_j_placeList_listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                //  put extra
                Log.d("Put Extra", "Put extra");
                viewPlace.putExtra("Place", placeList.get(i));

                Log.d("Go to next activity", "View Place");
                startActivity(viewPlace);


            }
        });
    }
    public void fillListView()
    {

        adapter = new PlaceListAdapter(this, placeList);
        lv_j_placeList_listOfPlaces.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.d("PlaceList", "Filled List View");
    }
}