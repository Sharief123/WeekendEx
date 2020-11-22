package com.example.weekendex;

public class Movies {

    int images;

    public Movies(int images, String names) {
        this.images = images;
        this.names = names;
    }

    public int getImages() {
        return images;
    }

    public String getNames() {
        return names;
    }

    String names;
}
