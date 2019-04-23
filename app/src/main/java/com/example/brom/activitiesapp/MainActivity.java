package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Create a ListView as in previous assignment*
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item_textview, R.id.list_item_textviewtest, listData);

        ListView my_listview = (ListView) findViewById(R.id.my_listview);
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String korv = new String("");
                Intent intent = new Intent(MainActivity.this, MountainDetailsActivity.class);
                intent.putExtra("HEIGHT", mountainHeights[i]);
                intent.putExtra("LOCATION", mountainLocations[i]);
                intent.putExtra("NAME", mountainNames[i]);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), korv+"Name:"+mountainNames[i]+ "|Location:"+mountainLocations[i]+"|Mountain height:"+mountainHeights[i], Toast.LENGTH_SHORT).show();
            }

        });
    }
/*
    public void launchMountainDetailsActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");

    }
    */
}
