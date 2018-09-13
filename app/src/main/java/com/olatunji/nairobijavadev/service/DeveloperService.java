package com.olatunji.nairobijavadev.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Olatunji on 11/09/2018.
 */

public class DeveloperService {
    private Retrofit retrofit = null;
    public static final String BASE_URL = "https://api.github.com";

    public DeveloperApi getApi() {
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(DeveloperApi.class);
    }
}
