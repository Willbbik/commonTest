package com.example.commontest.observerpattern;

public interface ISubject {

    void addObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    int notifyObserver();
}
