package com.olatunji.nairobijavadev.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yso on 06/09/2018.
 */

public class Developers {
    @SerializedName("login")
    private final String username;

    @SerializedName("html_url")
    private final String github;

    @SerializedName("avatar_url")
    private final String imageUrl;

    public Developers(String username, String github, String imageUrl) {
        this.username = username;
        this.imageUrl = imageUrl;
        this.github = github;
    }

    public String getUsername() {
        return username;
    }

    public String getGithub() {
        return github; }

    public String getImageUrl() {
        return imageUrl;
    }
}
