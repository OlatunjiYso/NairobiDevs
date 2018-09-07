package com.olatunji.nairobijavadev;

/**
 * Created by Yso on 06/09/2018.
 */

public class Developers {
    private String username;
    private String imageUrl;

    public Developers(String username, String imageUrl){
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public String getUsername(){
        return username;
    }

    public String getImageUrl(){
        return imageUrl;
    }
}
