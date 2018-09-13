package com.olatunji.nairobijavadev.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.olatunji.nairobijavadev.adapter.DevListAdapter;
import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.model.DevelopersResponse;
import com.olatunji.nairobijavadev.service.DeveloperService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperPresenter {
    private DeveloperService developerService;
    private final Context context;

    public DeveloperPresenter(Context context) {
    this.context = context;
    if (this.developerService == null) {
        this.developerService = new DeveloperService();
    }
    }

    public void getDevelopers(final RecyclerView recyclerView) {
        developerService
                .getApi()
                .getDevelopersList()
                .enqueue(new Callback<DevelopersResponse>() {

                    @Override
                    public void onResponse(
                            @NonNull Call<DevelopersResponse> call,
                            @NonNull Response<DevelopersResponse> response
                    ) {
                        List<Developers> developersList =
                                response.body().getDevelopersList();

                        if (developersList != null) {
                            RecyclerView.Adapter adapter =
                                    new DevListAdapter(developersList, context);
                            recyclerView.setAdapter(adapter);

                        }
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
