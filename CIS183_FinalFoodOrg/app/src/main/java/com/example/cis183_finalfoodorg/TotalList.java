package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TotalList extends AppCompatActivity {
    Intent HomePage;
    Intent PlaceList;
    Intent Use;
    ListView lv_j_totalList_listOfItems;
    ImageView btn_j_totalList_use;
    ImageView btn_j_totalList_home;
    ImageView btn_j_totalList_place;
    ImageView btn_j_totalList_sort;
    DatabaseHelper dbHelper;
    ArrayList<Item> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_list);
        lv_j_totalList_listOfItems =findViewById(R.id.lv_v_totalList_totalItemsList);

        btn_j_totalList_home = (ImageView) findViewById(R.id.btn_v_totalList_home);
        btn_j_totalList_place = (ImageView) findViewById(R.id.btn_v_totalList_place);
        btn_j_totalList_use = (ImageView) findViewById(R.id.btn_v_totalList_use);
        btn_j_totalList_sort = (ImageView) findViewById(R.id.btn_v_totalList_sort);

        Use = new Intent(TotalList.this, Use.class);
        HomePage = new Intent(TotalList.this, HomePage.class);
        PlaceList = new Intent(TotalList.this, PlaceList.class);

        dbHelper = new DatabaseHelper(this);
        itemList = new ArrayList<Item>();


        //  get all items for logged in user
        itemList = dbHelper.getAllItems();

        //  check which user is signed in

        //  get all items for said user in Item.java list

        //  call "fillListView()" which will instate the listview with the list's items


        ButtonEventHandler();
        fillTotalListView();
    }

    public void ButtonEventHandler()
    {
        btn_j_totalList_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        btn_j_totalList_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PlaceList);
            }
        });
        btn_j_totalList_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Use);
            }
        });
        btn_j_totalList_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    public void fillTotalListView()
    {

        //  TESTING PURPOSES
        for (int i = 0; i < itemList.size(); i++)
        {
            Log.d("Item: " + i, " " + itemList.get(i).getProduct());

        }




    }


}