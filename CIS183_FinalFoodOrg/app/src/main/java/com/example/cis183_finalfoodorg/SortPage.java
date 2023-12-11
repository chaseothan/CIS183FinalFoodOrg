package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    ImageView btn_j_sortPage_name;
    ImageView btn_j_sortPage_cost;
    ImageView btn_j_sortPage_amount;
    ImageView btn_j_sortPage_expdate;
    Intent TotalList;
    Boolean isDecending;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_page);
        tv_j_sortPage_amount = findViewById(R.id.tv_v_sortPage_amount);
        tv_j_sortPage_product = findViewById(R.id.tv_v_sortPage_product);
        tv_j_sortPage_cost = findViewById(R.id.tv_v_sortPage_cost);
        tv_j_sortPage_expDate = findViewById(R.id.tv_v_sortPage_expDate);
        s_j_sortPage_switch = findViewById(R.id.sw_v_sortPage_switch);
        btn_sortPage_j_list =(ImageView) findViewById(R.id.btn_v_sortPage_list);

        btn_j_sortPage_name = (ImageView) findViewById(R.id.btn_v_sortPage_name);
        btn_j_sortPage_amount = (ImageView) findViewById(R.id.btn_v_sortPage_amount);
        btn_j_sortPage_cost = (ImageView) findViewById(R.id.btn_v_sortPage_cost);
        btn_j_sortPage_expdate = (ImageView) findViewById(R.id.btn_v_sortPage_expdate);

        TotalList = new Intent(SortPage.this, TotalList.class);





        buttonClickEventHandler();
    }


    public void buttonClickEventHandler()
    {

        btn_j_sortPage_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //  pass totalList "username"
                //  put extra
                Log.d("Put Extra", "Put extra");
                TotalList.putExtra("Sort", "product");

                isDecending = s_j_sortPage_switch.isChecked();
                TotalList.putExtra("Decending", isDecending);

                Log.d("Go to next activity", "TotalList");
                startActivity(TotalList);
            }
        });
        btn_j_sortPage_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  pass totalList "amount"
                Log.d("Put Extra", "Put extra");
                TotalList.putExtra("Sort", "amount");

                Log.d("Go to next activity", "TotalList");
                startActivity(TotalList);
            }
        });
        btn_j_sortPage_cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  pass totalList "cost"
                Log.d("Put Extra", "Put extra");
                TotalList.putExtra("Sort", "cost");

                Log.d("Go to next activity", "TotalList");
                startActivity(TotalList);
            }
        });
        btn_j_sortPage_expdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  pass totalList "expdate"
                Log.d("Put Extra", "Put extra");
                TotalList.putExtra("Sort", "expdate");

                Log.d("Go to next activity", "TotalList");
                startActivity(TotalList);
            }
        });
        btn_sortPage_j_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TotalList);
            }
        });


    }


}