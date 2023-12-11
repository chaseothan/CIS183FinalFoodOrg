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
        super(context, DATABASE_NAME , null, 10);
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

    //  Initialize
    // ==============================================================================================
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
            SQLiteDatabase db = this.getWritableDatabase();

            //  userId
            //  username
            //  password

            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('zmoore', 'coolpass12');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('sthomas', 'beanSoup7');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('dwaneJson', 'theRockDudes');");
            db.execSQL("INSERT INTO " + TABLE_USERS + "  (username, password) VALUES ('Pinokio', 'yolo39');");

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
            SQLiteDatabase db = this.getWritableDatabase();

            //  placeId
            //  placename
            //  userId

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Cabnet', 'zmoore');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Fridge', 'sthomas');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Freezer', 'sthomas');");

            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Cabnet', 'dwaneJson');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Fridge', 'Pinokio');");
            db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('Freezer', 'Pinokio');");

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

    // ==============================================================================================


    public int totalNumberEntries(String tableName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);
        db.close();

        return numRows;


    }


    //  Username
    // ==============================================================================================
    public boolean addNewUser(String u, String p)
    {

        if (checkIfUsernameExists(u))
        {
            //  Bad pick another
            return false;
        }
        else
        {
            SQLiteDatabase db = this.getWritableDatabase();

            //  check if the username is unique first

            db.execSQL("INSERT INTO " + TABLE_USERS + " VALUES ('" + u + "','" + p + "')");

            db.close();
            return true;
        }



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


        SQLiteDatabase db = getReadableDatabase();

        String checkUsername = "SELECT count(username) FROM " + TABLE_USERS + " WHERE username = '" + username + "';";

        Cursor cursor = db.rawQuery(checkUsername, null);

        cursor.moveToFirst();

        int count = cursor.getInt(0);

        db.close();


        if (count != 0)
        {

            return true;
        }
        else
        {

            return  false;
        }

    }


    public boolean correctUserNameAndPassword(String username, String password)
    {


        if (checkIfUsernameExists(username))
        {

            String getUserInfo = "SELECT password from " + TABLE_USERS + " WHERE username = '" + username + "';";

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery(getUserInfo, null);

            if (cursor != null)
            {
                cursor.moveToFirst();

                if (password.equals(cursor.getString(0).toString()))
                {


                    //  correct username and password, log in

                    db.close();
                    return true;

                }
                else
                {

                    //  correct username, but incorrect password
                    db.close();
                    return false;
                }


            }
            else
            {
                //  incorrect username

                db.close();
            }



        }


        return false;


    }

    @SuppressLint("Range")
    public String getPassword()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String password = ("SELECT password FROM " + TABLE_USERS + " WHERE username = '" + AppData.getUsername() + "';");

        Cursor cursor = db.rawQuery(password, null);

        if (cursor.moveToFirst())
        {
            password = cursor.getString(cursor.getColumnIndex("password"));

        }

        db.close();
        return password;

    }
    public void updatePassword(String n)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + TABLE_USERS + " SET password = '" + n + "' WHERE username = '" + AppData.getUsername() + "';");

        db.close();
    }

    // ==============================================================================================
    //  Item
    public void addNewItem(Item n)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        //  db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('Eggs', '12', '8.99', '12/15/2023', '12/03/2023', '1');");

        db.execSQL("INSERT INTO " + TABLE_ITEMS + " (product, amount, cost, expdate, purchasedate, placeId) VALUES ('" + n.getProduct() + "','" + n.getAmount() + "','" + n.getCost() + "','" + n.getExpdate() + "','" + n.getPurchasedate() + "','" + n.getLocation() + "');");

        db.close();

    }
    public void removeItem(Item n)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE itemId = '" + n.getItemId() + "';");

        db.close();
    }
    public void updateItem(Item n)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + TABLE_ITEMS + " SET product = '" + n.getProduct() + "', amount = '" + n.getAmount() + "', cost = '" + n.getCost() + "', expdate = '" + n.getExpdate() + "', purchasedate = '" + n.getPurchasedate() + "', placeId = '" + n.getLocation() + "' WHERE itemId = '" + n.getItemId() + "';");

        db.close();
    }
    @SuppressLint("Range")
    public ArrayList<Item> sortAllItemsBy(String sortBy)
    {


        ArrayList<Item> itemList = new ArrayList<Item>();

        String selectQuery = "SELECT * FROM " + TABLE_USERS + " INNER JOIN " + TABLE_PLACES + " ON " + TABLE_PLACES + ".username = " + TABLE_USERS + ".username " + "INNER JOIN " + TABLE_ITEMS + " ON " + TABLE_PLACES + ".placeId = " + TABLE_ITEMS + ".placeId WHERE " + TABLE_USERS + ".username = '" +  AppData.getUsername() + "' ORDER BY " + sortBy + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        int itemId;
        String productName;
        int amount;
        double cost;
        String expdate;
        String purchasedate;
        int location;


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
                itemId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("itemId")));
//
                itemList.add(new Item(productName, amount, cost, expdate, purchasedate, location, itemId));
                //Log.d("getAllItems", " piece = " + location);
            }
            while (cursor.moveToNext());


        }

        db.close();

        return itemList;

    }


    @SuppressLint("Range")
    public ArrayList<Item> getAllItems()
    {

        ArrayList<Item> itemList = new ArrayList<Item>();

        String selectQuery = "SELECT * FROM " + TABLE_USERS + " INNER JOIN " + TABLE_PLACES + " ON " + TABLE_PLACES + ".username = " + TABLE_USERS + ".username " + "INNER JOIN " + TABLE_ITEMS + " ON " + TABLE_PLACES + ".placeId = " + TABLE_ITEMS + ".placeId WHERE " + TABLE_USERS + ".username = '" +  AppData.getUsername() + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        int itemId;
        String productName;
        int amount;
        double cost;
        String expdate;
        String purchasedate;
        int location;


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
                itemId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("itemId")));
//
                itemList.add(new Item(productName, amount, cost, expdate, purchasedate, location, itemId));
                //Log.d("getAllItems", " piece = " + location);
            }
            while (cursor.moveToNext());


        }

        db.close();

        return itemList;




    }

    @SuppressLint("Range")
    public ArrayList<Item> getAllItemsByPlace(int id)
    {

        ArrayList<Item> itemList = new ArrayList<Item>();

        String selectQuery = "SELECT * FROM " + TABLE_ITEMS + " WHERE placeId = '" + id + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        int itemId;
        String productName;
        int amount;
        double cost;
        String expdate;
        String purchasedate;
        int location;


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
                itemId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("itemId")));
//
                itemList.add(new Item(productName, amount, cost, expdate, purchasedate, location, itemId));
                //Log.d("getAllItems", " piece = " + location);
            }
            while (cursor.moveToNext());


        }

        db.close();

        return itemList;




    }

    //  ==============================================================================================
    //  Places
    public void updatePlace(Place n)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + TABLE_PLACES + " SET placename = '" + n.getPlace() + "' WHERE placeId = '" + n.getPlaceId() + "';");

        db.close();
    }


    @SuppressLint("Range")
    public ArrayList<Place> getAllPlaces()
    {
        ArrayList<Place> listOfPlaces = new ArrayList<Place>();

        String selectQuery = "SELECT * FROM " + TABLE_PLACES + " WHERE username = '" + AppData.getUsername() + "'";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String placename;

        String username;
        int placeId;

        if (cursor.moveToFirst())
        {
            do {

                //Log.d("getAllPlaces", "start do");
                placename = cursor.getString(cursor.getColumnIndex("placename"));
                username = cursor.getString(cursor.getColumnIndex("username"));



                placeId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("placeId")));
                //.d("getAllPlaces", "placeId = " + placeId);


                listOfPlaces.add(new Place(placename, username, placeId));
                //Log.d("getAllPlaces", "post .add");
            }
            while (cursor.moveToNext());
        }



        db.close();
        return listOfPlaces;
    }
    public void addNewPlace(String p)
    {

        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL("INSERT INTO " + TABLE_PLACES + " (placename, username) VALUES ('" + p + "','" + AppData.getUsername() + "')");

        db.close();

    }


    //  ==============================================================================================




}
