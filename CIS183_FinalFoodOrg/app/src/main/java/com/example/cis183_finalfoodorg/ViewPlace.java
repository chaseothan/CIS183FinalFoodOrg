package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ViewPlace extends AppCompatActivity {

    Button btn_j_viewPlace_list;

    Intent TotalListIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place);

        btn_j_viewPlace_list = findViewById(R.id.btn_viewPlace_list);
    }
}