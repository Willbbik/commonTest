package com.example.commontest.singletoneBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Autowired
    public Alphabet alphabet;

    public String getAlphabetName(){
        return alphabet.getName();
    }

    public void changeAlphabetName(String name){
        alphabet.changeName(name);
    }

}
