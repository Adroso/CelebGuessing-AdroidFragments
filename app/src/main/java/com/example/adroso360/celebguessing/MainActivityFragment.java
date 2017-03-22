package com.example.adroso360.celebguessing;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private GridView gridview;
    private ArrayAdapter<String> names;
    private ImageView imgView;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_main, container, false);

        imgView = (ImageView) v.findViewById(R.id.imgView);
        imgView.setImageDrawable(getResources().getDrawable(R.drawable.adele));


        names = new ArrayAdapter<String>(v.getContext(), simple_list_item_1);
        gridview = (GridView) v.findViewById(R.id.gridView);
        gridview.setAdapter(names);

        names.add("Adele");
        names.add("James Cordon");
        names.add("Robert Downey Jr");
        names.add("Richard Hammond");
        names.add("Obama");
        names.add("Trump");
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(v.getContext(),"Position Selected: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return v;


    }
}
