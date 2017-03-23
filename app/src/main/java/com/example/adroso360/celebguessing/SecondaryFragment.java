package com.example.adroso360.celebguessing;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondaryFragment extends Fragment {

    public Button triGrid;
    public Button pentaGrid;
    public Button octaGrid;
    public static int gridAmount;

    public SecondaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.fragment_secondary, container, false);
        triGrid = (Button) v2.findViewById(R.id.button);
        pentaGrid = (Button) v2.findViewById(R.id.button2);
        octaGrid = (Button) v2.findViewById(R.id.button3);

        triGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridAmount = 3;
            }
        });
        pentaGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridAmount = 5;

            }
        });
        octaGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridAmount = 8;

            }
        });



        return v2;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
