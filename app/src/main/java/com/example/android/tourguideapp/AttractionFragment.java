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
public class AttractionFragment extends Fragment {


    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view_items, container, false);


        final ArrayList<Item> itemsInList = new ArrayList<>();
        itemsInList.add(new Item(R.string.budatin, R.string.budatinDesc, 49.2363, 18.7348, R.drawable.budatin));
        itemsInList.add(new Item(R.string.kostol, R.string.kostolDesc, 49.224436, 18.740829, R.drawable.kostol));


        ItemAdapter adapter = new ItemAdapter(getActivity(), itemsInList, R.color.mustSeeList);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = itemsInList.get(i);

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
