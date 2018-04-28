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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsFragment extends Fragment {


    public BarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view_items, container, false);


        final ArrayList<Item> itemsInList = new ArrayList<>();
        itemsInList.add(new Item(R.string.bar1, R.string.barDesc,49.2163,18.7248,R.drawable.zep));
        itemsInList.add(new Item(R.string.bar2, R.string.bar2Desc,49.224436,18.740829, R.drawable.smer));
        itemsInList.add(new Item(R.string.bar3, R.string.bar3Desc,49.226,18.749, R.drawable.golem));
        itemsInList.add(new Item(R.string.bar4, R.string.bar4Desc,49.2153,18.74243, R.drawable.guiness));

        ItemAdapter adapter = new ItemAdapter(getActivity(), itemsInList, R.color.mustSeeList);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = itemsInList.get(i);

                // Create a Uri from an intent string. Use the result to create an Intent.
                String string1 = "geo:" + item.getmLon() + "," + item.getmLat() ;
                Uri gmmIntentUri = Uri.parse(string1);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));

                startActivity(mapIntent);
            }
        });
        return rootView;
    }
}

