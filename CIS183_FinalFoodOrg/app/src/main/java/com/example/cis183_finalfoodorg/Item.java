package com.example.cis183_finalfoodorg;

public class Item
{



    //  class used for transporting and storing items across intents, shouldn't need itemId, that's for the database helper
    //private int itemId;
    private String product;
    private int amount;
    private double cost;
    private String expdate;
    private String purchasedate;
    private int location;
    private int itemId;


    public Item()
    {

    }

    public Item(String p, int a, double c, String ex, String pd, int l, int Id)
    {

        itemId = Id;
        product = p;
        amount = a;
        cost = c;
        expdate = ex;
        purchasedate = pd;
        location = l;


    }


    public void setProduct(String p) {
        product = p;
    }

    public void setAmount(int a) {
        this.amount = a;
    }

    public void setCost(double c) {
        this.cost = c;
    }

    public void setExpdate(String ex) {
        this.expdate = ex;
    }

    public void setPurchasedate(String pd) {
        this.purchasedate = pd;
    }

    public void setLocation(int l) {
        this.location = l;
    }

    //  ======================================================

    public String getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public double getCost() {
        return cost;
    }

    public String getExpdate() {
        return expdate;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public int getLocation() {
        return location;
    }

}
