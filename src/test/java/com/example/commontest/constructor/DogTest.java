package com.example.commontest.constructor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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


    @Test
    @DisplayName("forName 메소드를 이용해서 인스턴스 만들기")
    void createClass() throws Exception {
        //given
        String dogName = "황구";
        int dogAge = 2;

        //when
        Class<Dog> dogClass = (Class<Dog>) Class.forName("com.example.commontest.constructor.Dog");
        Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class);
        Dog dog = constructor.newInstance(dogName, dogAge);

        //then
        assertEquals(dog.displayDogName(), dogName);
        assertEquals(dog.displayDogAge(), dogAge);
    }

    @Test
    @DisplayName("Class객체를이용한메소드실행")
    void callMethod() throws Exception {

        //when
        Class<Dog> dogClass = (Class<Dog>) Class.forName("com.example.commontest.constructor.Dog");
        Method displayDogName = dogClass.getMethod("displayDogName");
        String result = (String) displayDogName.invoke(new Dog());

        //then
        //Note. Dog 클래스의 기본 생성자 사용시 기본이름이 황구임
        assertEquals(result, "황구");
    }


}