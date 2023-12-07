package com.example.cis183_finalfoodorg;

public class Place
{


    private String username;
    private String place;

    public Place()
    {

    }

    public Place (String u, String p)
    {
        username = u;
        place = p;

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

    //username string
    //place name string
}
