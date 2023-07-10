package com.example.commontest.constructor;

public class Dog {

    private String name;
    public int age;

    private GENDER gender;

    public enum GENDER {
        COCK, FEMALE
    }

    public Dog() {
        this.name = "황구";
        this.age = 1;
        this.gender = GENDER.COCK;
    }

    public Dog(String name) {
        this.name = name;
        this.age = 1;
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
