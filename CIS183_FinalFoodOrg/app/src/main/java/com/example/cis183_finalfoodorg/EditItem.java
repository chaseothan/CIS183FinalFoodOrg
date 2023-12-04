package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class EditItem extends AppCompatActivity {
    Intent HomePage;
    Intent ProductProfile;
    ImageView btn_j_editItem_edit;
    ImageView Btn_j_editItem_home;
    EditText et_j_editItem_product;
    EditText et_j_editItem_amount;
    EditText et_j_editItem_location;
    EditText et_j_editItem_cost;
    EditText et_j_editItem_expDate;
    EditText et_j_editItem_purchaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        btn_j_editItem_edit = (ImageView) findViewById(R.id.btn_v_editItem_edit);
        Btn_j_editItem_home = (ImageView) findViewById(R.id.btn_v_editItem_home);

        et_j_editItem_product = findViewById(R.id.et_v_editItem_product);
        et_j_editItem_amount = findViewById(R.id.et_v_editItem_amount);
        et_j_editItem_location = findViewById(R.id.et_v_editItem_location);
        et_j_editItem_cost = findViewById(R.id.et_v_editItem_cost);
        et_j_editItem_expDate = findViewById(R.id.et_v_editItem_expDate);
        et_j_editItem_purchaseDate = findViewById(R.id.et_v_editItem_purchaseDate);

        ProductProfile = new Intent(EditItem.this, ProductProfile.class);
        HomePage = new Intent(EditItem.this, HomePage.class);

        ButtonEventHandler();
    }
    public void ButtonEventHandler()
    {
        btn_j_editItem_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ProductProfile);
            }
        });
        btn_j_editItem_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
    }
}