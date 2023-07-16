package com.example.commontest.objectcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewBookStore {

    private String name;

    List<Book> books = new ArrayList<>();

    NewBookStore(String name){
        this.name = name;
    }

    NewBookStore(String name, List<Book> books){
        this.name = name;
        this.books = books.stream()
                .map(book -> new Book(book.getName()))
                .collect(Collectors.toList());
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeBooks(List<Book> books) {
        this.books = books.stream()
                .map(book -> new Book(book.getName()))
                .collect(Collectors.toList());
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
