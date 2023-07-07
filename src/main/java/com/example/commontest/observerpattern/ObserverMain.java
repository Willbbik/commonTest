package com.example.commontest.observerpattern;

public class ObserverMain {

    public void publish() {
        ISubject publisher = new Publisher();

        IObserver o1 = new Subscriber1();
        IObserver o2 = new Subscriber2();
        IObserver o3 = new Subscriber3();

        publisher.addObserver(o1);
        publisher.addObserver(o2);
        publisher.addObserver(o3);

        publisher.notifyObserver();
        publisher.removeObserver(o1);
        publisher.notifyObserver();
    }

}
