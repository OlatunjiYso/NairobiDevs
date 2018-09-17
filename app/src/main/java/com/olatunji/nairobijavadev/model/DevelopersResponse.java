package com.olatunji.nairobijavadev.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Olatunji on 11/09/2018.
 */
public class DevelopersResponse {
    @SerializedName("items")
    private ArrayList<Developers> developersList;

    public ArrayList<Developers> getDevelopersList() {
        return developersList;
    }
}
