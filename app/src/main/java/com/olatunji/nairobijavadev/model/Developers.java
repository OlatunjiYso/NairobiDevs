package com.olatunji.nairobijavadev.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yso on 06/09/2018.
 */

public class Developers implements Parcelable {
    @SerializedName("login")
    private final String username;

    @SerializedName("html_url")
    private final String github;

    @SerializedName("avatar_url")
    private final String imageUrl;

    public String getUsername() {
        return username;
    }

    public String getGithub() {
        return github; }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Developers(Parcel in) {
        username = in.readString();
        imageUrl = in.readString();
        github = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(imageUrl);
        dest.writeString(github);
    }

    public static final Creator<Developers> CREATOR = new Creator<Developers>() {
        @Override
        public Developers createFromParcel(Parcel in) {
            return new Developers(in);
        }
        @Override
        public Developers[] newArray(int size) {
            return new Developers[size];
        }
    };
}
