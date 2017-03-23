package com.example.adroso360.celebguessing;

import android.content.res.TypedArray;
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

import java.net.URISyntaxException;
import java.util.Objects;
import static android.R.layout.simple_list_item_1;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static GridView gridview;
    private static ArrayAdapter<String> names;
    private ImageView imgView;
    public int currentPicture;
    private int gridSum = 3;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_main, container, false);
        imgView = (ImageView) v.findViewById(R.id.imgView);
        randomImage();

        try {
            gridSum = SecondaryFragment.gridAmount;
        } catch (Exception e){
            gridSum = 3;
        }

        names = new ArrayAdapter<String>(v.getContext(), simple_list_item_1);
        gridview = (GridView) v.findViewById(R.id.gridView);
        gridview.setAdapter(names);
        names.clear();
        if (gridSum==3){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
        }else if(gridSum == 5){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
            names.add("Richard Hammond");
            names.add("Obama");
        }else if(gridSum == 8){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
            names.add("Richard Hammond");
            names.add("Obama");
            names.add("Trump");
            names.add("Homer Simpson");
            names.add("Jason Holdsworth");
            names.add("Adam");
        }
        updateView(5);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(v.getContext(),names.getItem(position), Toast.LENGTH_SHORT).show();
               Boolean playerWin = checkWin(names.getItem(position), currentPicture);
                if (playerWin){
                    Toast.makeText(v.getContext(),"YOU WON", Toast.LENGTH_SHORT).show();
                    randomImage();
                }else {
                    Toast.makeText(v.getContext(),"TRY AGAIN", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }

    public static boolean checkWin(String userSelection, int currentPic){
        //Obama ID:23 Trump ID:24 Adele ID:3 Hammo ID:9 Cordo ID:21 Downy ID:4
        return (Objects.equals(userSelection, "Adele") && currentPic == 0) || (Objects.equals(userSelection, "James Cordon") && currentPic == 1) || (Objects.equals(userSelection, "Robert Downey Jr") && currentPic == 2) || (Objects.equals(userSelection, "Richard Hammond") && currentPic == 3) || (Objects.equals(userSelection, "Obama") && currentPic == 4) || (Objects.equals(userSelection, "Trump") && currentPic == 5) ;

    }
    public void randomImage(){
        final TypedArray images = getResources().obtainTypedArray(R.array.celebImages);
        final int choice = (int) (Math.random() * images.length());
        currentPicture = choice;
        //System.out.println(choice);
        imgView.setImageResource(images.getResourceId(choice, R.drawable.adele)); //adele on default
        images.recycle();
    }
    public static void updateView(int gridSum){

        gridview.setAdapter(names);
        names.clear();
        if (gridSum==3){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
        }else if(gridSum == 5){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
            names.add("Richard Hammond");
            names.add("Obama");
        }else if(gridSum == 8){
            names.add("Adele");
            names.add("James Cordon");
            names.add("Robert Downey Jr");
            names.add("Richard Hammond");
            names.add("Obama");
            names.add("Trump");
            names.add("Homer Simpson");
            names.add("Jason Holdsworth");
            names.add("Adam");
        }


    }
}
