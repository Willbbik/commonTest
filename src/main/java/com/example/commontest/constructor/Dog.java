package com.example.commontest.constructor;

public class Dog {

    private String name;
    public int age;

    private Dog() {
        this.name = "황구";
        this.age = 1;
    }

    public Dog(String name) {
        this.name = name;
        this.age = 1;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
