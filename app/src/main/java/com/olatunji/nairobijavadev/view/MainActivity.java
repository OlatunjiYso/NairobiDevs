package com.olatunji.nairobijavadev.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.olatunji.nairobijavadev.R;
import com.olatunji.nairobijavadev.presenter.DeveloperPresenter;

public class MainActivity extends AppCompatActivity {

    private final DeveloperPresenter developerPresenter = new DeveloperPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        developerPresenter.getDevelopers(recyclerView);
    }
}
