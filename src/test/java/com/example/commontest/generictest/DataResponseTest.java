package com.example.commontest.generictest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

class DataResponseTest {

    private ObjectMapper objectMapper;
    private ResourcePatternResolver resourcePatternResolver;
    private String requestUrl = "classpath:book.json";

    @BeforeEach
    public void setup() throws Exception {
        objectMapper = new ObjectMapper();
        resourcePatternResolver = new PathMatchingResourcePatternResolver();
    }

//    private <T> DataResponse<T> request(String requestUrl, Class<T> clazz) throws Exception {
//        System.out.println("asdf");
//    }

    @Test
    void name() {
        System.out.println("asdf");
    }
}