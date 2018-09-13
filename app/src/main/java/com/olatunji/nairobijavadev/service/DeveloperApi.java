package com.olatunji.nairobijavadev.service;

import com.olatunji.nairobijavadev.model.DevelopersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Olatunji on 11/09/2018.
 */
public interface DeveloperApi {
    @GET("search/users?q=language:java+location:nairobi&per_page=40&sort=followers")
    Call<DevelopersResponse> getDevelopersList();
}
