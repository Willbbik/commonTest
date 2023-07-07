package com.example.commontest.observerpattern;

public class Subscriber1 implements IObserver {

    public void update(){
        System.out.println("test1");
    }
}
