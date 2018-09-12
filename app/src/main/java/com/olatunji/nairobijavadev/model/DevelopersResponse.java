package com.olatunji.nairobijavadev.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Olatunji on 11/09/2018.
 */
public class DevelopersResponse {
    @SerializedName("items")
    private List<Developers> developersList;

    public List<Developers> getDevelopersList() {
        return developersList;
    }
}
