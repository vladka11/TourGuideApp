package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vladislavakopalova on 27.4.18.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    private int mColorResourceId;

    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name_text_view);
        name.setText(currentItem.getmName());

        TextView desc = (TextView) listItemView.findViewById(R.id.description_text_view);
        desc.setText(currentItem.getmDescription());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image_item);
        image.setImageResource(currentItem.getmImageId());
        image.setVisibility(View.VISIBLE);

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItemView;


    }
}
