package com.example.edify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    private FirebaseAuth fa;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // list_view is used to display the contents one by one in settings menu
        lv = findViewById(R.id.listView);
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("About Edify");
        arrayList.add("FAQ and Support");
        arrayList.add("Tutorial");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i refers position
                if(i == 0)
                {
                    startActivity(new Intent(SettingsActivity.this,AboutActivity.class));
                }

                // ... can extend further based on i values

            }
        });


        //used to switch between one tab to another tab
        fa = FirebaseAuth.getInstance();
        BottomNavigationView btm = findViewById(R.id.bottom_navigation);

        btm.setSelectedItemId(R.id.settings);  // prof, settings

        btm.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), LearnActivity.class));
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.prof:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.settings:
                        return;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.teach:
                        startActivity(new Intent(getApplicationContext(), TeachActivity.class));
                        overridePendingTransition(0, 0);
                        break;

                }
            }
        });
    }

}