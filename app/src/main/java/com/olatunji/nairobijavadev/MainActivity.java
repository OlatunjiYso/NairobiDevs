package com.olatunji.nairobijavadev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Developers> allDevelopers = new ArrayList<>();
    static {
        allDevelopers.add(new Developers("Roger Taracha", "www.image.com"));
        allDevelopers.add(new Developers("Kolawole Taiwo", "www.image.com"));
        allDevelopers.add(new Developers("Olatunji Yusuf", "www.image.com"));
        allDevelopers.add(new Developers("Leumas Abudu", "www.image.com"));
        allDevelopers.add(new Developers("Chinwoke Hygnius", "www.image.com"));
        allDevelopers.add(new Developers("Javadeveloper 12", "www.image.com"));
        allDevelopers.add(new Developers("Javadeveloper 10", "www.image.com"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new DevListAdapter(allDevelopers, this);
        recyclerView.setAdapter(adapter);
    }
}
