package com.example.commontest.singletoneBean;

import org.springframework.stereotype.Component;

@Component
public class Alphabet {

    private String name = "originAlphabet";

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
