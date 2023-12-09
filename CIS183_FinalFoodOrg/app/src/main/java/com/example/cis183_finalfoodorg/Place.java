package com.example.cis183_finalfoodorg;

import java.io.Serializable;

public class Place implements Serializable
{


    private String username;
    private String place;
    private int placeId;

    public Place()
    {

    }

    public Place (String p, String u, int id)
    {
        username = u;
        place = p;
        placeId = id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String u) {
        username = u;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String p) {
        place = p;
    }

    public int getPlaceId()
    {
        return placeId;
    }

    //username string
    //place name string
}
