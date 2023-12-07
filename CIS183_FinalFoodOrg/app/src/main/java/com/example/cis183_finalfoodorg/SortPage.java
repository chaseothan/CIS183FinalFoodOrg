package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class SortPage extends AppCompatActivity {
    TextView tv_j_sortPage_product;
    TextView tv_j_sortPage_cost;
    TextView tv_j_sortPage_amount;
    TextView tv_j_sortPage_expDate;
    Switch s_j_sortPage_switch;
    ImageView btn_sortPage_j_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_page);
        tv_j_sortPage_amount = findViewById(R.id.tv_v_sortPage_amount);
        tv_j_sortPage_product = findViewById(R.id.tv_v_sortPage_product);
        tv_j_sortPage_cost = findViewById(R.id.tv_v_sortPage_cost);
        tv_j_sortPage_expDate = findViewById(R.id.tv_v_sortPage_expDate);
        s_j_sortPage_switch = findViewById(R.id.switch1);
        btn_sortPage_j_list =(ImageView) findViewById(R.id.btn_v_sortPage_list);


    }
}