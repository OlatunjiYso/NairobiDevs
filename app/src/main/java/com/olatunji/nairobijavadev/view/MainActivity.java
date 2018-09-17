package com.olatunji.nairobijavadev.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.olatunji.nairobijavadev.R;
import com.olatunji.nairobijavadev.adapter.DevListAdapter;
import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.presenter.DeveloperPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DeveloperPresenter.View {

    public ArrayList<Developers> developersList;
    DeveloperPresenter developerPresenter = new DeveloperPresenter(this);
    public static final String DEVELOPERS_LIST = "saved_state";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

    @Override
    public void displayDevelopersList(ArrayList<Developers> listOfDevelopers) {
        developersList = listOfDevelopers;
        if (developersList != null) {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter adapter = new DevListAdapter(developersList, this);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      if (savedInstanceState != null) {
          developersList = savedInstanceState.getParcelableArrayList(DEVELOPERS_LIST);
          displayDevelopersList(developersList);
      } else {
          developerPresenter.getDevelopers();
      }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DEVELOPERS_LIST, developersList);
    }
}

