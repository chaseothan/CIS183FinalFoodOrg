package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddItem extends AppCompatActivity {

    EditText et_j_addItem_product;
    EditText et_j_addItem_amount;
    EditText et_j_addItem_location;
    EditText et_j_addItem_cost;
    EditText et_j_addItem_expDate;
    EditText et_j_addItem_purchaseDate;
    ImageView btn_j_addItem_home;
    ImageView  btn_j_addItem_add;
    Intent HomePageIntent;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        btn_j_addItem_add = (ImageView) findViewById(R.id.btn_v_addItem_add);
        btn_j_addItem_home = (ImageView) findViewById(R.id.btn_v_addItem_home);

        et_j_addItem_product = findViewById(R.id.et_v_addItem_product);
        et_j_addItem_amount = findViewById(R.id.et_v_addItem_amount);
        et_j_addItem_location = findViewById(R.id.et_v_addItem_location);
        et_j_addItem_cost = findViewById(R.id.et_v_addItem_cost);
        et_j_addItem_expDate = findViewById(R.id.et_v_addItem_expDate);
        et_j_addItem_purchaseDate = findViewById(R.id.et_v_addItem_purchaseDate);

        HomePageIntent = new Intent(AddItem.this, HomePage.class);

        dbHelper = new DatabaseHelper(this);

        ButtonEventHandler();

    }
    public void ButtonEventHandler()
    {
        btn_j_addItem_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Button Click", "pre item grab");
                Item newItem = new Item(et_j_addItem_product.getText().toString(), Integer.parseInt(et_j_addItem_amount.getText().toString()), Double.parseDouble(et_j_addItem_cost.getText().toString()), et_j_addItem_expDate.getText().toString(), et_j_addItem_purchaseDate.getText().toString(), Integer.parseInt(et_j_addItem_location.getText().toString()));

                Log.d("Button Click", "post item grab");
                dbHelper.addNewItem(newItem);


                startActivity(HomePageIntent);
            }
        });
        btn_j_addItem_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePageIntent);

            }
        });
    }
}