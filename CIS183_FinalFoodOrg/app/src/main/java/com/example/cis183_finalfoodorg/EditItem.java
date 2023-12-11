package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditItem extends AppCompatActivity {
    Intent HomePage;
    Intent ProductProfile;
    ImageView btn_j_editItem_edit;
    ImageView Btn_j_editItem_home;
    EditText et_j_editItem_product;
    EditText et_j_editItem_amount;
    Spinner sp_j_editItem_location;
    EditText et_j_editItem_cost;
    EditText et_j_editItem_expDate;
    EditText et_j_editItem_purchaseDate;
    Item itemPassed;
    DatabaseHelper dbHelper;
    ImageView btn_j_editItem_remove;
    ArrayList<Place> listOfPlaces;
    ArrayAdapter spinnerArrayAdapter;
    String[] placeNames;
    int[] placeIds;
    int selectedPlaceId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        btn_j_editItem_edit = (ImageView) findViewById(R.id.btn_v_editItem_edit);
        Btn_j_editItem_home = (ImageView) findViewById(R.id.btn_v_editItem_home);
        btn_j_editItem_remove = (ImageView) findViewById(R.id.btn_v_editItem_remove);

        et_j_editItem_product = findViewById(R.id.et_v_editItem_product);
        et_j_editItem_amount = findViewById(R.id.et_v_editItem_amount);
        et_j_editItem_cost = findViewById(R.id.et_v_editItem_cost);
        et_j_editItem_expDate = findViewById(R.id.et_v_editItem_expDate);
        et_j_editItem_purchaseDate = findViewById(R.id.et_v_editItem_purchaseDate);

        Intent cameFrom = getIntent();

        itemPassed = (Item) cameFrom.getSerializableExtra("Item");

        ProductProfile = new Intent(EditItem.this, ProductProfile.class);
        HomePage = new Intent(EditItem.this, HomePage.class);

        dbHelper = new DatabaseHelper(this);
        listOfPlaces = dbHelper.getAllPlaces();

        selectedPlaceId = -999;

        placeNames = new String[listOfPlaces.size()];
        placeIds = new int[listOfPlaces.size()];

        for (int i = 0; i < listOfPlaces.size(); i++)
        {
            placeNames[i] = listOfPlaces.get(i).getPlace().toString();
            placeIds[i] = listOfPlaces.get(i).getPlaceId();
        }



//        //  My baby spinner =================================================================================
        sp_j_editItem_location =(Spinner) findViewById(R.id.sp_v_editItem_location);
        spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, placeNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_j_editItem_location.setAdapter(spinnerArrayAdapter);
//        //  ====================================================================================================

        et_j_editItem_product.setText(itemPassed.getProduct());
        et_j_editItem_amount.setText(String.valueOf(itemPassed.getAmount()));
        //et_j_editItem_location.setText(String.valueOf(itemPassed.getLocation()));
        et_j_editItem_cost.setText(String.valueOf(itemPassed.getCost()));
        et_j_editItem_expDate.setText(itemPassed.getExpdate());
        et_j_editItem_purchaseDate.setText(itemPassed.getPurchasedate());

        ButtonEventHandler();
    }
    public void ButtonEventHandler()
    {
        btn_j_editItem_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (et_j_editItem_product.getText().toString().equals("") || et_j_editItem_amount.getText().toString().equals("") || et_j_editItem_cost.getText().toString().equals("") || et_j_editItem_expDate.getText().toString().equals("") || et_j_editItem_purchaseDate.getText().toString().equals("") || selectedPlaceId == -999)
                {

                    Log.d("AddItem Click", "Missing Fields");

                }
                else if (isInt(et_j_editItem_amount.getText().toString()) == false || isDouble(et_j_editItem_cost.getText().toString()) == false)
                {


                    Log.d("Add, else if", "int/double wrong");


                }
                else
                {


                    // make new item with id = 0, because database wont care and we have yet to create it
                    Item updatedItem = new Item(et_j_editItem_product.getText().toString(), Integer.parseInt(et_j_editItem_amount.getText().toString()), Double.parseDouble(et_j_editItem_cost.getText().toString()), et_j_editItem_expDate.getText().toString(), et_j_editItem_purchaseDate.getText().toString(), selectedPlaceId, itemPassed.getItemId());

                    ProductProfile.putExtra("Item", updatedItem);

                    dbHelper.updateItem(updatedItem);

                    startActivity(ProductProfile);
                }





            }
        });
        Btn_j_editItem_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        btn_j_editItem_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.removeItem(itemPassed);
                startActivity(HomePage);
            }
        });

        sp_j_editItem_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id)
            {
                Toast.makeText(EditItem.this, placeNames[i], Toast.LENGTH_SHORT).show();
                selectedPlaceId = placeIds[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }

    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }

}