package com.example.cis183_finalfoodorg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_j_main_login;
    Button btn_j_main_addNewUser;
    Button btn_j_main_editUser;
    ListView lv_j_main_listOfUsers;
    EditText et_j_main_username;
    EditText et_j_main_password;



    Intent HomePageintent;
    Intent NewUserPageIntent;
    Intent EditUserIntent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //btn_j_main_totalList = findViewById(R.id.btn_v_main_editUser);
        //btn_j_main_placeList = findViewById(R.id.btn_v_main_removeUser);
        lv_j_main_listOfUsers = findViewById(R.id.lv_v_main_listofusers);

        et_j_main_password = findViewById(R.id.et_v_main_password);
        et_j_main_username = findViewById(R.id.et_v_main_username);

        btn_j_main_addNewUser = findViewById(R.id.btn_v_main_addUser);
        btn_j_main_editUser = findViewById(R.id.btn_v_main_edituser);
        btn_j_main_login = findViewById(R.id.btn_v_main_login);


        EditUserIntent = new Intent(MainActivity.this, EditUser.class);
        NewUserPageIntent = new Intent(MainActivity.this, NewUserPage.class);
        HomePageintent = new Intent(MainActivity.this, HomePage.class);


        //TotalListIntent = new Intent(MainActivity.this, TotalList.class);
        //PlaceListIntent = new Intent(MainActivity.this, PlaceList.class);

        ButtonClickEventHandler();
    }

    public void ButtonClickEventHandler()
    {

        //btn_j_main_totalList.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view)
           // {

            //    startActivity(TotalListIntent);

            //}
        //});

        //btn_j_main_placeList.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view)
          //  {
           //     startActivity(PlaceListIntent);
          //  }
       // });

        btn_j_main_addNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NewUserPageIntent);
            }
        });
        btn_j_main_editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditUserIntent);
            }
        });
        btn_j_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //later in the if statement check if the user name and password are valid
                if (true)
                    {
                    startActivity(HomePageintent);
                    }
            }
        });

    }



}