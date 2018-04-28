package com.example.android.tourguideapp;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view_items, container, false);


        final ArrayList<Item> itemsInList = new ArrayList<>();
        itemsInList.add(new Item(R.string.food1, R.string.food1Desc,49.2363,18.7348,R.drawable.tretie));
        itemsInList.add(new Item(R.string.food2, R.string.food2Desc,49.236,18.7408, R.drawable.polovnicky));
        itemsInList.add(new Item(R.string.food3, R.string.food3Desc,49.2236,18.74029, R.drawable.narohu));
        itemsInList.add(new Item(R.string.food4, R.string.food4Desc,49.2246,18.7409, R.drawable.manzo));



        ItemAdapter adapter = new ItemAdapter(getActivity(), itemsInList, R.color.mustSeeList);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = itemsInList.get(i);

                // Create a Uri from an intent string. Use the result to create an Intent.
                String string1 = "geo:" + item.getmLon() + "," + item.getmLat() + "?q=" + item.getmLon() + "," + item.getmLat();
                Uri gmmIntentUri = Uri.parse(string1);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));

                startActivity(mapIntent);
            }
        });
        return  rootView;
    }

}
