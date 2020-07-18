package com.mycustomlistview.saisreenivas.mycustomlistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private ListView list;
    private CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[]{
                "1.Mocking bird",
                "2.India 2020",
                "3.Envisioning an Empowered Nation",
                "4.You Are Born To Blossom",
                "5.Target 3 Billion",
                "6.A Manifesto for Change",
                "7.Reignited",
                "8.Transcendence My Spiritual Experiences",
                "9.My Journey",
                "10.Ondomitable Spirit",
                "11.Ignited Minds: Unleasing the Power within India",
                "12.The Luminious Sparks"
        };

        final String[] bookAuthors = new String[]{
                "A.P.J. Abdul Kalam",
                "Missile Man of India",
                "A.P.J. Abdul Kalam",
                "Missile Man of India",
                "A.P.J. Abdul Kalam",
                "Missile Man of India",
                "A.P.J. Abdul Kalam",
                "Missile Man of India",
                "A.P.J. Abdul Kalam",
                "Missile Man of India",
                "A.P.J. Abdul Kalam",
                "Missile Man of India"
        };

        final String[] bookPages = new String[]{
                "150 pages",
                "300 pages",
                "250 pages",
                "200 pages",
                "350 pages",
                "300 pages",
                "250 pages",
                "50 pages",
                "150 pages",
                "200 pages",
                "150 pages",
                "300 pages"
        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();
        for(int i=0;i<10;i++){

            HashMap<String,String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("author", bookAuthors[i]);
            data.put("pages", bookPages[i]);

            authorList.add(data);
        }
        list = (ListView) findViewById(R.id.list);
        adapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int intPosition = position;
                String itemClickedId = list.getItemAtPosition(intPosition).toString();

                Toast.makeText(getApplicationContext(), "Item Selected: " + itemClickedId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
