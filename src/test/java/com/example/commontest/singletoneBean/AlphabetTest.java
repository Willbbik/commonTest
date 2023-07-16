package com.example.commontest.singletoneBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AlphabetTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    void test(){
        assertEquals(a.alphabet, b.alphabet);
        assertEquals(a.alphabet.getName(), "originAlphabet");
        assertEquals(b.alphabet.getName(), "originAlphabet");
        System.out.println("a.alphabet :" + a.alphabet);
        System.out.println("b.alphabet :" + b.alphabet);
        System.out.println("a.alphabet.getName() :" + a.alphabet.getName());
        System.out.println("b.alphabet.getName() :" + b.alphabet.getName());

        a.changeAlphabetName("good");

        assertEquals(a.alphabet.getName(), "good");
        assertEquals(b.alphabet.getName(), "good");

        System.out.println("a.alphabet :" + a.alphabet);
        System.out.println("b.alphabet :" + b.alphabet);
        System.out.println("a.alphabet.getName() :" + a.alphabet.getName());
        System.out.println("b.alphabet.getName() :" + b.alphabet.getName());
    }

}