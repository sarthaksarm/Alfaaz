package com.example.sarthakmishra.alfaz;

public class PeopleName {

    private String musicname, author;

    public PeopleName(String NAME, String author){
        this.musicname = NAME;
        this.author=author;
    }

    public String getName() {
        return this.musicname;
    }
    public String getAuthor() {
        return this.author;
    }
}
