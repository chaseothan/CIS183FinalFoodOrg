package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddItem extends AppCompatActivity {

    EditText et_j_addItem_product;
    EditText et_j_addItem_amount;
    Spinner sp_j_addItem_location;
    EditText et_j_addItem_cost;
    EditText et_j_addItem_expDate;
    EditText et_j_addItem_purchaseDate;
    ImageView btn_j_addItem_home;
    ImageView  btn_j_addItem_add;
    Intent HomePageIntent;
    ArrayAdapter spinnerArrayAdapter;
    ArrayList<Place> listOfPlaces;
    String[] placeNames;
    int[] placeIds;
    int selectedPlaceId;


    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        btn_j_addItem_add = (ImageView) findViewById(R.id.btn_v_addItem_add);
        btn_j_addItem_home = (ImageView) findViewById(R.id.btn_v_addItem_home);

        et_j_addItem_product = findViewById(R.id.et_v_addItem_product);
        et_j_addItem_amount = findViewById(R.id.et_v_addItem_amount);

        selectedPlaceId = -999;

        dbHelper = new DatabaseHelper(this);
        listOfPlaces = dbHelper.getAllPlaces();

        placeNames = new String[listOfPlaces.size()];
        placeIds = new int[listOfPlaces.size()];

        for (int i = 0; i < listOfPlaces.size(); i++)
        {
            placeNames[i] = listOfPlaces.get(i).getPlace().toString();
            placeIds[i] = listOfPlaces.get(i).getPlaceId();
        }



//        //  My baby spinner =================================================================================
        sp_j_addItem_location =(Spinner) findViewById(R.id.mtdvaeI_tino_dcoadd_l);
        spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, placeNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_j_addItem_location.setAdapter(spinnerArrayAdapter);
//        //  ====================================================================================================



        et_j_addItem_cost = findViewById(R.id.et_v_addItem_cost);
        et_j_addItem_expDate = findViewById(R.id.et_v_addItem_expDate);
        et_j_addItem_purchaseDate = findViewById(R.id.et_v_addItem_purchaseDate);



        HomePageIntent = new Intent(AddItem.this, HomePage.class);



        ButtonEventHandler();

    }
    public void ButtonEventHandler()
    {
        btn_j_addItem_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  check for filled out
                if (et_j_addItem_product.getText().toString().equals("") || et_j_addItem_amount.getText().toString().equals("") || et_j_addItem_cost.getText().toString().equals("") || et_j_addItem_expDate.getText().toString().equals("") || et_j_addItem_purchaseDate.getText().toString().equals("") || selectedPlaceId == -999)
                {

                    Log.d("AddItem Click", "Missing Fields");

                }
                else
                {



                    // make new item with id = 0, because database wont care and we have yet to create it
                    Item newItem = new Item(et_j_addItem_product.getText().toString(), Integer.parseInt(et_j_addItem_amount.getText().toString()), Double.parseDouble(et_j_addItem_cost.getText().toString()), et_j_addItem_expDate.getText().toString(), et_j_addItem_purchaseDate.getText().toString(), selectedPlaceId, 0);

                    dbHelper.addNewItem(newItem);


                    startActivity(HomePageIntent);
                }


            }
        });
        btn_j_addItem_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePageIntent);

            }
        });

        sp_j_addItem_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id)
            {
                Log.d("ItemSelect Button", "Enter");


                Toast.makeText(AddItem.this, placeNames[i], Toast.LENGTH_SHORT).show();
                selectedPlaceId = placeIds[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }





}