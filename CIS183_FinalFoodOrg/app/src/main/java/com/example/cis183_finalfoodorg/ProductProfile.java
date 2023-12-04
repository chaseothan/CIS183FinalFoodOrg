package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductProfile extends AppCompatActivity {
    Intent HomePage;
    Intent EditItem;
    ImageView btn_j_productProfile_edit;
    ImageView btn_j_productProfile_home;
    TextView tv_j_productProfile_product;
    TextView tv_j_productProfile_amount;
    TextView tv_j_productProfile_location;
    TextView tv_j_productProfile_cost;
    TextView tv_j_productProfile_expDate;
    TextView tv_j_productProfile_purchaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_profile);
        btn_j_productProfile_edit = (ImageView) findViewById(R.id.btn_v_productProfile_edit);
        btn_j_productProfile_home = (ImageView) findViewById(R.id.btn_v_productProfile_home);

        tv_j_productProfile_product = findViewById(R.id.tv_v_productProfile_product);
        tv_j_productProfile_amount = findViewById(R.id.tv_v_productProfile_amount);
        tv_j_productProfile_location = findViewById(R.id.tv_v_prodcutProfile_location);
        tv_j_productProfile_cost = findViewById(R.id.tv_v_productProfile_cost);
        tv_j_productProfile_expDate = findViewById(R.id.tv_v_productProfile_expDate);
        tv_j_productProfile_purchaseDate = findViewById(R.id.tv_v_productProfile_purchaseDate);

        EditItem = new Intent(ProductProfile.this, EditItem.class);
        HomePage = new Intent(ProductProfile.this, HomePage.class);

        ButtonEventHandler();
        //fill func for tvs
    }
    public void ButtonEventHandler()
    {
        btn_j_productProfile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditItem);
            }
        });
        btn_j_productProfile_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
    }
}