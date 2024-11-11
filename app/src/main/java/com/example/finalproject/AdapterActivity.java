package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterActivity extends ArrayAdapter<String> {

    public AdapterActivity(Context context, ArrayList<String> recentActivities) {
        super(context, 0, recentActivities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_recent_activity, parent, false);
        }

        String activity = getItem(position);
        TextView activityTextView = convertView.findViewById(R.id.activityTextView);
        activityTextView.setText(activity);

        return convertView;
    }
}
