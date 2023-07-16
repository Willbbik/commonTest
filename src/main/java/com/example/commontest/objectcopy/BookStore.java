package com.example.commontest.objectcopy;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private String name;

    List<Book> books = new ArrayList<>();

    BookStore (String name){
        this.name = name;
    }

    BookStore (String name, List<Book> books){
        this.name = name;
        this.books = new ArrayList<>(books);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeBooks(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
