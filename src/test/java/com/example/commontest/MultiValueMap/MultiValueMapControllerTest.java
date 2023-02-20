package com.example.commontest.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MultiValueMapControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .timeZone("Asia/Seoul")
                .build();
    }

    @Test
    @DisplayName("같은 필드명으로 여러개가 넘어가면 List에 담긴다.")
    void test() {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("a", "b", "c"));

        URI uri = UriComponentsBuilder.fromUriString("/mvm")
                .queryParams(params)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restTemplate.exchange(uri
                , HttpMethod.GET
                , new HttpEntity<>(headers)
                , String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).contains("a");
        assertThat(response.getBody()).contains("b");
        assertThat(response.getBody()).contains("c");
    }

    @Test
    @DisplayName("CustomMultiValueMapConverter를 사용하여 요청이 되는지 확인")
    void test2() {

        //given
        String expectedName = "name";
        MultiValueMapTestDto1 dto = MultiValueMapTestDto1.builder()
                .name(expectedName)
                .build();

        //when
        MultiValueMap<String, String> result = CustomMultiValueMapConverter.convert(objectMapper, dto);


        URI uri = UriComponentsBuilder.fromUriString("/mvm")
                .queryParams(result)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restTemplate.exchange(uri
                , HttpMethod.GET
                , new HttpEntity<>(headers)
                , String.class
        );

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).contains(expectedName);
    }
}