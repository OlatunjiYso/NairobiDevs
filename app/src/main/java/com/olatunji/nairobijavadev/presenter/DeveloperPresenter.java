package com.olatunji.nairobijavadev.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.model.DevelopersResponse;
import com.olatunji.nairobijavadev.service.DeveloperService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperPresenter {
    private DeveloperService developerService;
    private final View view;


    public DeveloperPresenter(View view) {
    this.view = view;
    if (this.developerService == null) {
        this.developerService = new DeveloperService();
    }
    }

    public interface View {
        void displayDevelopersList(ArrayList<Developers> list);

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
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            Log.e("onFailure", e + "An error occurred");
                        }

                    }
                });
    }
}
