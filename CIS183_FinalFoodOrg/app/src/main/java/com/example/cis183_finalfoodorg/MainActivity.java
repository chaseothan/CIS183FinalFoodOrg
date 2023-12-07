package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //make image view later when we get the asset
    ImageView btn_j_main_login;
    ImageView btn_j_main_addNewUser;
    EditText et_j_main_username;
    EditText et_j_main_password;
    DatabaseHelper dbHelper;
    Intent HomePageintent;
    Intent NewUserPageIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        dbHelper.initializeAllTables();

        Log.d("USERS Count: ", dbHelper.totalNumberEntries("Users") + "");
        Log.d("PLACES Count: ", dbHelper.totalNumberEntries("Places") + "");
        Log.d("ITEMS Count: ", dbHelper.totalNumberEntries("Items") + "");


        //btn_j_main_totalList = findViewById(R.id.btn_v_main_editUser);
        //btn_j_main_placeList = findViewById(R.id.btn_v_main_removeUser);

        et_j_main_password = findViewById(R.id.et_v_main_password);
        et_j_main_username = findViewById(R.id.et_v_main_username);

        btn_j_main_addNewUser =(ImageView) findViewById(R.id.btn_v_main_addUser);
        btn_j_main_login =(ImageView) findViewById(R.id.btn_v_main_enter);


        NewUserPageIntent = new Intent(MainActivity.this, NewUserPage.class);
        HomePageintent = new Intent(MainActivity.this, HomePage.class);


        //TotalListIntent = new Intent(MainActivity.this, TotalList.class);
        //PlaceListIntent = new Intent(MainActivity.this, PlaceList.class);

        ButtonClickEventHandler();
        dbHelper.getAllUsernames();

    }

    public void ButtonClickEventHandler()
    {


        btn_j_main_addNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("did","click");
                startActivity(NewUserPageIntent);

            }
        });
        btn_j_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkUsernameAndPasswordNotNull())
                {
                    if (dbHelper.correctUserNameAndPassword(et_j_main_username.getText().toString(), et_j_main_password.getText().toString()))
                    {

                        //  correct username and password
                        //  procceed to next page

                        //  static class for logged in user
                        Log.d("check","match");
                        startActivity(HomePageintent);
                    }
                    else
                    {

                        //  either one is incorrect, you don't need to know
                        //  display an error
                        Log.d("On click else", "either incorrect");


                    }

                }
                else
                {
                    //  did not
                    Log.d("On click else", "null");

                }


            }
        });

    }

    public boolean checkUsernameAndPasswordNotNull()
    {

        if (et_j_main_username.getText().toString() != "" && et_j_main_password.getText().toString() != "")
        {
            //  not null
            return true;
        }
        else
        {
            //  is null
            return false;
        }


    }



}