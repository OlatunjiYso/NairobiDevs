package com.olatunji.nairobijavadev.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.olatunji.nairobijavadev.R;
import com.olatunji.nairobijavadev.adapter.DevListAdapter;
import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.presenter.DeveloperPresenter;
import com.olatunji.nairobijavadev.util.EspressoIdlingResource;
import com.olatunji.nairobijavadev.util.NetworkConnection;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DeveloperPresenter.View {

    public ArrayList<Developers> developersList;
    DeveloperPresenter developerPresenter = new DeveloperPresenter(this);
    public static final String DEVELOPERS_LIST = "saved_state";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

    ProgressDialog progressDialog;
    SwipeRefreshLayout swipeContainer;


    @Override
    public void displayDevelopersList(ArrayList<Developers> listOfDevelopers) {

            developersList = listOfDevelopers;
            if (developersList != null) {
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.getLayoutManager().isAttachedToWindow();
                RecyclerView.Adapter adapter = new DevListAdapter(developersList, this);
                recyclerView.setAdapter(adapter);
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (swipeContainer != null && swipeContainer.isRefreshing()) {
                swipeContainer.setRefreshing(false);
                Toast.makeText(this, "Developers list refreshed",
                        Toast.LENGTH_LONG).show();
            }
            EspressoIdlingResource.decrement();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (NetworkConnection.connectionStatus(this)) {

            if (savedInstanceState != null) {
                developersList = savedInstanceState.getParcelableArrayList(DEVELOPERS_LIST);
                displayDevelopersList(developersList);

            } else {
                EspressoIdlingResource.increment();
                fetchDeveloperList();
            }

            swipeContainer = findViewById(R.id.swipe_container);
            swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    developerPresenter.getDevelopers();
                }
            });
        } else {
                Snackbar.make(findViewById(R.id.coordinator),
                        "Please enable an internet connection", Snackbar.LENGTH_INDEFINITE)
                        .setAction("NETWORK OPTION", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                                if (intent.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intent);
                                }
                            }
                        })
                        .show();
        }
    }

    private void fetchDeveloperList() {
        progressDialog = ProgressDialog.show(this, "Kenya Java Developers",
                "Loading... Please wait .....", false, false);
        developerPresenter.getDevelopers();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DEVELOPERS_LIST, developersList);
    }

    @Override
    public void displaySlowNetwork() {
        progressDialog.hide();
        Snackbar.make(findViewById(R.id.coordinator), "Slow network.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fetchDeveloperList();
                    }
                })
                .show();
    }

}

