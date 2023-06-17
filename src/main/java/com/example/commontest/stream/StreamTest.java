package com.example.commontest.stream;

import java.util.List;

public class StreamTest {

    public List<Integer> intStreamFilter() {
        List<Integer> beforeList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> afterList = beforeList.stream()
                .filter(d -> d < 6)
                .toList();

        return afterList;
    }

}
