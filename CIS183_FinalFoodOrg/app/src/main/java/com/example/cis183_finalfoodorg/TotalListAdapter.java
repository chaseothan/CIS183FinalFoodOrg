package com.example.cis183_finalfoodorg;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class TotalListAdapter extends BaseAdapter
{
Context context;
ArrayList<Item> listOfItems;

public TotalListAdapter(Context c, ArrayList<Item> ls){
    context = c;
    listOfItems = ls;
}
    @Override
    public int getCount() {
        return listOfItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null)
        {
            LayoutInflater minflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = minflator.inflate(R.layout.custom_total_list_cell, null);

        }

        TextView tv_j_customCell_totalList_product = view.findViewById(R.id.tv_v_customCell_totalList_product);
        Item item = listOfItems.get(i);
        tv_j_customCell_totalList_product.setText(item.getProduct());

        return view;
    }

}
