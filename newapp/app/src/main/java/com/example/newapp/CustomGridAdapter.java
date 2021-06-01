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

public class CustomGridAdapter extends ArrayAdapter<language> {
    private static final String TAG = "CustomGridAdapter";
    private Context mContext;
    int mResource;

    public CustomGridAdapter(Context context, int resource, ArrayList<language> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String original  = getItem(position).getOriginal();
        String translation = getItem(position).getTranslation();

        language lan = new language(original,translation);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tview1 = (TextView) convertView.findViewById(R.id.langorig);
        TextView tview2 = (TextView) convertView.findViewById(R.id.langtrans);

        tview1.setText(original);
        tview2.setText(translation);

        return convertView;
    }
}
