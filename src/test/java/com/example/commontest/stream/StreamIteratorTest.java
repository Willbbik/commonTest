package com.example.commontest.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamIteratorTest {

    @Test
    @DisplayName("stream의 iterator을 사용해서 Collection 즉 List로 변환이 가능한지 테스트")
    public void iteratorToList(){

        List<String> originList = List.of("a", "b", "c");

        Assertions.assertThrows(ClassCastException.class, () -> {
            List<String> newList = (List<String>) originList.stream()
                    .iterator();
        });
    }

    @Test
    public void iteratorForeach(){
        List<String> originList = List.of("a", "b", "c");

        for(String temp : (Iterable<String>)originList.stream().iterator()){
            originList.contains(temp);
        }
    }

}