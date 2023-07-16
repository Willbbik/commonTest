package com.example.commontest.objectcopy;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private String name;

    List<Book> books = new ArrayList<>();

    BookStore (String name){
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
