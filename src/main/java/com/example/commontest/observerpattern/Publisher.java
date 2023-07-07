package com.example.commontest.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject {

    List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public int notifyObserver() {
        int result = 0;

        for (IObserver o : observers) {
            o.update();
            result ++;
        }

        return result;
    }
}
