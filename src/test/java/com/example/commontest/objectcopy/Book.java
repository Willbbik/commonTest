package com.example.commontest.objectcopy;

public class Book {

    private String name;

    Book (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }
}