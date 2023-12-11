package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TotalList extends AppCompatActivity {
    Intent HomePage;
    Intent PlaceList;
    Intent Use;
    Intent Sort;
    ListView lv_j_totalList_listOfItems;
    ImageView btn_j_totalList_use;
    ImageView btn_j_totalList_home;
    ImageView btn_j_totalList_place;
    ImageView btn_j_totalList_sort;
    DatabaseHelper dbHelper;
    ArrayList<Item> itemList;
    TotalListAdapter adapter;
    Intent productProfile;
    String sortPassed;




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
        Sort = new Intent(TotalList.this, SortPage.class);
        productProfile = new Intent(TotalList.this, ProductProfile.class);

        Log.d("Total List", "===========================");

        Intent cameFrom = getIntent();

        //  reset just for safekeeping
        sortPassed = "";
        sortPassed = (String) cameFrom.getStringExtra("Sort");



        dbHelper = new DatabaseHelper(this);
        itemList = new ArrayList<Item>();



        //  get all items for logged in user
        if (sortPassed != "")
        {
            Log.d("Total List", "sort passed != ''");
            itemList = dbHelper.sortAllItemsBy(sortPassed);
        }
        else
        {
            Log.d("Total List", "sort passed == ''");
            itemList = dbHelper.getAllItems();
        }


        //  check which user is signed in

        //  get all items for said user in Item.java list

        //  call "fillListView()" which will instate the listview with the list's items

        Log.d("Total List", "===========================");

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
            public void onClick(View v) { startActivity(Sort);

            }
        });
        lv_j_totalList_listOfItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                productProfile.putExtra("Item", itemList.get(position));

                startActivity(productProfile);
            }
        });
        lv_j_totalList_listOfItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                


                return false;
            }
        });
    }



    public void fillTotalListView()
    {

        adapter = new TotalListAdapter(this, itemList);
        lv_j_totalList_listOfItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}