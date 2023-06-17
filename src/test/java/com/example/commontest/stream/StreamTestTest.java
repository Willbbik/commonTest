package com.example.commontest.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamTestTest {

    @Test
    void intStreamFilterTest() {
        StreamTest streamTest = new StreamTest();

        List<Integer> list = streamTest.intStreamFilter();
        assertEquals(list.size(), 5);
    }
}