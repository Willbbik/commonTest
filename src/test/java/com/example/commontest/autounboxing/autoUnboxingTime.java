package com.example.commontest.autounboxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class autoUnboxingTime {

    private WrapperClass wrapperClass = new WrapperClass();
    private PrimitiveClass primitiveClass = new PrimitiveClass();

    @Test
    public void test(){

        Long primitiveClassTime = primitiveClass.run();
        Long wrapperClassTime = wrapperClass.run();

        System.out.println("wrapperClassTime : " + wrapperClassTime);
        System.out.println("primitiveClassTime : " + primitiveClassTime);

        int result = primitiveClassTime.compareTo(wrapperClassTime);
        Assertions.assertEquals(result,-1);
    }

}
