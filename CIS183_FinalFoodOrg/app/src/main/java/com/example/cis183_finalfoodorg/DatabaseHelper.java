package com.example.cis183_finalfoodorg;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "FoodOrganizer.db";
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_PLACES = "Places";
    private static final String TABLE_ITEMS = "Items";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        //db.execSQL("CREATE TABLE " + TABLE_USERS + " (userId )");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (userId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username VARCHAR(255), password VARCHAR(255));");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_PLACES + " (placeId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placename VARCHAR(255), FOREIGN KEY (userId) REFERENCES Users (userId));");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ITEMS + " (itemId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, product VARCHAR(255), amount INTEGER, cost DOUBLE, expdate VARCHAR(255), purchasedate VARCHAR(255), FOREIGN KEY (placeId) REFERENCES Places (placeID));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

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

    public boolean initialize_UsersTable()
    {
        if (totalNumberEntries(TABLE_USERS) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            //  userId
            //  username
            //  password

            db.execSQL("INSERT INTO " + TABLE_USERS + " (username, password) VALUES ('zmoore', 'coolpass12');");
            db.execSQL("INSERT INTO " + TABLE_USERS + " (username, password) VALUES ('sthomas', 'beanSoup7');");
            db.execSQL("INSERT INTO " + TABLE_USERS + " (username, password) VALUES ('dwaneJson', 'theRockDudes');");

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
            SQLiteDatabase db = this.getWritableDatabase();

            //  placeId
            //  placename
            //  userId

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Cabnet', '1');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Fridge', '2');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Freezer', '2');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Cabnet', '3');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Fridge', '3');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, userId) VALUES ('Freezer', '3');");

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
            SQLiteDatabase db = this.getWritableDatabase();

            //  itemId
            //  product
            //  amount
            //  cost
            //  expdate
            //  purchasedate
            //  placeId


            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '1');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Bacon', '6', '12.99', '12/05/2023', '11/20/2023', '2');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Mayo', '1', '4.99', '3/19/2024', '12/03/2023', '3');");

            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '4');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Turkey', '1', '35.50', '12/8/2023', '12/03/2023', '5');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Horse', '20', '16', '12/04/2023', '12/03/2023', '6');");

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
