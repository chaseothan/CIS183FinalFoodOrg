package com.example.cis183_finalfoodorg;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "FoodOrganizer.db";
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_PLACES = "Places";
    private static final String TABLE_ITEMS = "Items";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 5);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {


        Log.d("onCreate", "Start");
        db.execSQL("Create table if not exists " + TABLE_USERS + " (username varchar(255) primary key not null,password varchar (255));");
        db.execSQL("Create table if not exists " + TABLE_PLACES + " (placeId integer primary key autoincrement not null,placename varchar (255), username2);");
        db.execSQL("Create table if not exists " + TABLE_ITEMS + " (itemId integer primary key autoincrement not null,product varchar (255),amount varchar (255),cost varchar (255), expdate varchar (255), purchasedate varchar(255), placeId2);");
        Log.d("onCreate", "End");


    }

    //db.execSQL("Create table if not exists " + TABLE_USERS + " (username varchar(255) primary key not null,password varchar (255));");
        //db.execSQL("Create table if not exists " + TABLE_PLACES + " (placeId integer primary key autoincrement not null,placename varchar (255), foreign key (username) references TABLE_USERS (username));");
        //db.execSQL("Create table if not exists " + TABLE_ITEMS + " (itemId integer primary key autoincrement not null,product varchar (255),amount varchar (255),cost varchar (255), expdate varchar (255), purchasedate varchar(255), foreign key (placeid) references TABLE_PLACES (placeid));");

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("OnUpgrade", "First");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS+ ";");

        onCreate(db);


    }

    public void initializeAllTables()
    {

        initialize_UsersTable();
        initialize_PlacesTable();
        initialize_ItemsTable();


    }

    //Log.d("init Users", "Get readable");
    public boolean initialize_UsersTable()
    {
        if (totalNumberEntries(TABLE_USERS) == 0)
        {
            Log.d("init Users", "Get readable");
            SQLiteDatabase db = this.getReadableDatabase();

            //  userId
            //  username
            //  password

            db.execSQL("INSERT INTO " + TABLE_USERS + "  VALUES ('zmoore', 'coolpass12');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  VALUES ('sthomas', 'beanSoup7');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  VALUES ('dwaneJson', 'theRockDudes');");

            db.close();

            return true;
        }
        else
        {
            return false;
        }



    }

    public boolean initialize_PlacesTable()
    {
        if (totalNumberEntries(TABLE_PLACES) == 0)
        {
            Log.d("init Places", "Get readable");
            SQLiteDatabase db = this.getReadableDatabase();

            //  placeId
            //  placename
            //  userId

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Cabnet', 'zmoore');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Fridge', 'sthomas');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Freezer', 'sthomas');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Cabnet', 'dwaneJson');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Fridge', 'dwaneJson');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username2) VALUES ('Freezer', 'dwaneJson');");

            db.close();

            return true;
        }
        else
        {
            return false;
        }



    }

    public boolean initialize_ItemsTable()
    {
        if (totalNumberEntries(TABLE_ITEMS) == 0)
        {
            Log.d("init Items", "Get readable");
            SQLiteDatabase db = this.getReadableDatabase();

            //  itemId
            //  product
            //  amount
            //  cost
            //  expdate
            //  purchasedate
            //  placeId


            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '1');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Bacon', '6', '12.99', '12/05/2023', '11/20/2023', '2');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Mayo', '1', '4.99', '3/19/2024', '12/03/2023', '3');");

            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '4');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Turkey', '1', '35.50', '12/8/2023', '12/03/2023', '5');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId2) VALUES ('Horse', '20', '16', '12/04/2023', '12/03/2023', '6');");

            db.close();

            return true;
        }
        else
        {
            return false;
        }



    }


    public int totalNumberEntries(String tableName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);
        db.close();

        return numRows;


    }


}
