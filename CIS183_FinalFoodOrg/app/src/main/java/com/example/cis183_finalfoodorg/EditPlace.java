package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class EditPlace extends AppCompatActivity {
    Intent ViewPlace;
    Intent HomePage;
    ImageView btn_j_editPlace_edit;
    ImageView btn_j_editPlace_home;
    EditText et_j_editPlace_nameOfPlace;
    Place placePassed;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_place);
        btn_j_editPlace_edit = (ImageView) findViewById(R.id.btn_v_editPlace_editPlace);
        btn_j_editPlace_home = (ImageView) findViewById(R.id.btn_v_editPlace_home);


        et_j_editPlace_nameOfPlace = findViewById(R.id.et_v_editPlace_nameOfPlace);

        ViewPlace = new Intent(EditPlace.this, ViewPlace.class);
        HomePage = new Intent(EditPlace.this, HomePage.class);

        Intent cameFrom = getIntent();

        placePassed = (Place) cameFrom.getSerializableExtra("Place");

        ButtonEventhandler();

        dbHelper = new DatabaseHelper(this);
        et_j_editPlace_nameOfPlace.setText(placePassed.getPlace());

    }
    public void ButtonEventhandler()
    {
        btn_j_editPlace_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomePage);
            }
        });
        btn_j_editPlace_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Place updatedPlace = new Place(et_j_editPlace_nameOfPlace.getText().toString(), placePassed.getUsername(), placePassed.getPlaceId());

                ViewPlace.putExtra("Place", updatedPlace);

                dbHelper.updatePlace(updatedPlace);

                startActivity(ViewPlace);
            }
        });





    }
}