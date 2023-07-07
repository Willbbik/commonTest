package com.example.commontest.observerpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverMainTest {

    @Test
    void publish() {
        ISubject publisher = new Publisher();

        IObserver o1 = new Subscriber1();
        IObserver o2 = new Subscriber2();
        IObserver o3 = new Subscriber3();

        publisher.addObserver(o1);
        publisher.addObserver(o2);
        publisher.addObserver(o3);


        assertEquals(publisher.notifyObserver(), 3);
    }


}