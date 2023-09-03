package com.example.commontest.rawtype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericClassTest {

    @Test
    void returnTypeValue() {

        //정상적인 제네릭 클래스
        GenericClass<String> genericClass1 = new GenericClass();
        String result1 = genericClass1.returnTypeValue("good");

        //정상적인 제네릭 클래스
        GenericClass<Boolean> genericClass2 = new GenericClass();
        boolean result2 = genericClass2.returnTypeValue(true);

        //비정상인 로타입
        GenericClass genericClass3 = new GenericClass();

        Assertions.assertEquals(result1, "good");
        Assertions.assertEquals(result2, true);
        Assertions.assertThrows(ClassCastException.class, () -> {
            int result3 = (int) genericClass3.returnTypeValue("test");
        });
    }



}