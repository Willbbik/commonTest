package com.example.commontest.constructor;

public class Dog {

    private String name = "황구";
    private int age = 1;

    private GENDER gender = GENDER.COCK;

    public enum GENDER {
        COCK, FEMALE
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, GENDER gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String displayDogName() {
        return this.name;
    }

    public int displayDogAge() {
        return this.age;
    }

    private GENDER displayDogGender() {
        return this.gender;
    }

}
