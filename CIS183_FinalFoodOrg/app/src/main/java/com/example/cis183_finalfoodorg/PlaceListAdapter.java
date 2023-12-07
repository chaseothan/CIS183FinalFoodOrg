package com.example.cis183_finalfoodorg;

import android.app.Activity;
import android.content.Context;
import android.icu.number.CompactNotation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class PlaceListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Place> listOfPlaces;
    @Override
    public int getCount() {
        return listOfPlaces.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfPlaces.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater minflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = minflator.inflate(R.layout.custom_place_list_cell, null);

        }
            return null;

    }
}
