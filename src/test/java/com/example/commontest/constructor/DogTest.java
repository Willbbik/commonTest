package com.example.commontest.constructor;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    public void getConstructors(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] declaredConstructors = dogClass.getDeclaredConstructors();

        for(Constructor constructor : declaredConstructors){
            constructor.setAccessible(true);

            System.out.println("[파라미터 개수] : " + constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();

            for(Parameter parameter : parameters){
                System.out.println("[파라미터 이름] : "+ parameter.getName());
                System.out.println("[파라미터 타입] : "+ parameter.getType());
            }
            System.out.println("----------------------------------");
        }
    }

}