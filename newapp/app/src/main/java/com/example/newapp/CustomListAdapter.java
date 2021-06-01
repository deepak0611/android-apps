package com.example.newapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<document> {
    private static final String TAG = "CustomListAdapter";
    private Context mContext;
    int mResource;

    public CustomListAdapter(Context context, int resource, ArrayList<document> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        String name = getItem(position).getName();

        document doc = new document(name);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tview = (TextView) convertView.findViewById(R.id.textView);

        tview.setText(name);

        return convertView;
    }
}
