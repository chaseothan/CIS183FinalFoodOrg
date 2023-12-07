package com.example.cis183_finalfoodorg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "FoodOrganizer.db";
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_PLACES = "Places";
    private static final String TABLE_ITEMS = "Items";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 8);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {


        Log.d("onCreate", "Start");
        db.execSQL("Create table if not exists " + TABLE_USERS + " (username varchar (255) primary key not null, password varchar (255));");
        db.execSQL("Create table if not exists " + TABLE_PLACES + " (placeId integer primary key autoincrement not null,placename varchar (255), username varchar (255), foreign key (username) references users (username));");
        db.execSQL("Create table if not exists " + TABLE_ITEMS + " (itemId integer primary key autoincrement not null,product varchar (255),amount varchar (255),cost varchar (255), expdate varchar (255), purchasedate varchar(255), placeId integer, foreign key (placeId) references places (placeId));");
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

            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('zmoore', 'coolpass12');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('sthomas', 'beanSoup7');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('dwaneJson', 'theRockDudes');");

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

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Cabnet', '1');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Fridge', '2');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Freezer', '2');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Cabnet', '3');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Fridge', '3');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Freezer', '3');");

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


            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '1');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Bacon', '6', '12.99', '12/05/2023', '11/20/2023', '2');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Mayo', '1', '4.99', '3/19/2024', '12/03/2023', '3');");

            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '4');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Turkey', '1', '35.50', '12/8/2023', '12/03/2023', '5');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Horse', '20', '16', '12/04/2023', '12/03/2023', '6');");

            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Chese', '12', '8.99', '12/15/2023', '12/03/2023', '4');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Balogna', '1', '35.50', '12/8/2023', '12/03/2023', '5');");
            db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Suspicious soup', '20', '16', '12/04/2023', '12/03/2023', '6');");

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


    public void addNewUser(String u, String p)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        //  check if the username is unique first

        db.execSQL("INSERT INTO " + TABLE_USERS + " VALUES ('" + u + "','" + p + "')");

        db.close();

    }

    @SuppressLint("Range")
    public void getAllUsernames()
    {

        //  string array

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT username FROM " + TABLE_USERS + ";";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
        {

            do
            {
                Log.d("Username: ", "" + cursor.getString(cursor.getColumnIndex("username")));
            }
            while (cursor.moveToNext());



        }

        db.close();

    }

    public boolean checkIfUsernameExists(String username)
    {

        Log.d("check username exists", "start");
        SQLiteDatabase db = getReadableDatabase();

        String checkUsername = "SELECT count(username) FROM " + TABLE_USERS + " WHERE username = '" + username + "';";

        Cursor cursor = db.rawQuery(checkUsername, null);

        cursor.moveToFirst();

        int count = cursor.getInt(0);

        db.close();

        Log.d("check username exists", "end");
        if (count != 0)
        {
            Log.d("Return ", "true");
            return true;
        }
        else
        {
            Log.d("Return ", "False");
            return  false;
        }

    }


    public boolean correctUserNameAndPassword(String username, String password)
    {

        Log.d("correct name combo", "start");
        if (checkIfUsernameExists(username))
        {
            Log.d("check username exists", "returned true");
            String getUserInfo = "SELECT password from " + TABLE_USERS + " WHERE username = '" + username + "';";

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery(getUserInfo, null);

            if (cursor != null)
            {
                cursor.moveToFirst();

                if (password.equals(cursor.getString(0).toString()))
                {

                    Log.d("check password", "good");
                    //  correct username and password, log in

                    db.close();
                    return true;

                }
                else
                {
                    Log.d("check password", "bad");
                    //  correct username, but incorrect password
                    db.close();
                    return false;
                }


            }
            else
            {
                //  incorrect username
                Log.d("No username", "None found");
                db.close();
            }



        }

        Log.d("end", "return false next");
        return false;


    }

    public void addNewItem(Item n)
    {
        Log.d("Database Helper", "Start of Add Item");
        SQLiteDatabase db = this.getWritableDatabase();



        //  db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '1');");

        db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('" + n.getProduct() + "','" + n.getAmount() + "','" + n.getCost() + "','" + n.getExpdate() + "','" + n.getPurchasedate() + "','" + n.getLocation() + "');");

        db.close();

    }

    @SuppressLint("Range")
    public ArrayList<Item> getAllItems()
    {

        Log.d("getAllItems", "Start");
        ArrayList<Item> itemList = new ArrayList<Item>();

        String selectQuery = "SELECT * FROM " + TABLE_ITEMS + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("getAllItems", "Statement");
        Cursor cursor = db.rawQuery(selectQuery, null);

        int itemId;
        String productName;
        int amount;
        double cost;
        String expdate;
        String purchasedate;
        int location;


        Log.d("getAllItems", "Move to first");
        if (cursor.moveToFirst())
        {

            do
            {
//                itemId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("itemId")));
                  productName = cursor.getString(cursor.getColumnIndex("product"));
                  amount = Integer.parseInt(cursor.getString(cursor.getColumnIndex("amount")));
                  cost = Double.parseDouble(cursor.getString(cursor.getColumnIndex("cost")));
                  expdate = cursor.getString(cursor.getColumnIndex("expdate"));
                  purchasedate = cursor.getString(cursor.getColumnIndex("purchasedate"));
                  location = Integer.parseInt(cursor.getString(cursor.getColumnIndex("placeId")));
//
                  itemList.add(new Item(productName, amount, cost, expdate, purchasedate, location));
                //Log.d("getAllItems", " piece = " + location);
            }
            while (cursor.moveToNext());


        }

        db.close();

        Log.d("getAllItems", "Return");
        return itemList;




    }
    @SuppressLint("Range")
    public ArrayList<Place> getAllPlaces()
    {
        ArrayList<Place> listOfPlaces = new ArrayList<Place>();

        String selectQuery = "SELECT * FROM " + TABLE_PLACES + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String placename;

        String username;

        if (cursor.moveToFirst())
        {
            do {

                Log.d("enter do", "exit do");
                placename = cursor.getString(cursor.getColumnIndex("placename"));
                username = cursor.getString(cursor.getColumnIndex("username"));

                listOfPlaces.add(new Place(placename, username));
            }
            while (cursor.moveToNext());
        }

        db.close();
        return listOfPlaces;
    }
    public void addNewPlace(String p, String u)
    {

        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('" + p + "','" + u + "')");

        db.close();

    }


}
