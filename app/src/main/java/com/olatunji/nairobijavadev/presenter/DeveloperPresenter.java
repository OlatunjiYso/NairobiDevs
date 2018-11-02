package com.olatunji.nairobijavadev.presenter;


import android.support.annotation.NonNull;

import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.model.DevelopersResponse;
import com.olatunji.nairobijavadev.service.DeveloperService;
import com.olatunji.nairobijavadev.view.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperPresenter {
    private DeveloperService developerService;
    private final View view;


    public DeveloperPresenter(MainActivity view) {
    this.view = view;
    if (this.developerService == null) {
        this.developerService = new DeveloperService();
    }
    }

    public interface View {
        void displayDevelopersList(ArrayList<Developers> list);
        void displaySlowNetwork();

    }
    public void getDevelopers() {
        developerService
                .getApi()
                .getDevelopersList()
                .enqueue(new Callback<DevelopersResponse>() {

                    @Override
                    public void onResponse(
                            @NonNull Call<DevelopersResponse> call,
                            @NonNull Response<DevelopersResponse> response
                    ) {
                        DevelopersResponse developersResponse = response.body();
                        ArrayList<Developers> developersList;

                        assert developersResponse != null;

                        developersList = developersResponse.getDevelopersList();

                        view.displayDevelopersList(developersList);
                    }

                    @Override

                    public void onFailure(@NonNull Call<DevelopersResponse> call,
                                          @NonNull Throwable t) {
                        view.displaySlowNetwork();

                    }
                });
    }
}
