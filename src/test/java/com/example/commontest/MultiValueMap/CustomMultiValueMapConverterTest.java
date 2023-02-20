package com.example.commontest.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.example.commontest.MultiValueMap.MultiValueMapTestDto1.Status.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CustomMultiValueMapConverterTest {

    ObjectMapper objectMapper;
    MultiValueMap<String, String> result;

    @BeforeEach
    void setUp() {
        objectMapper = new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .timeZone("Asia/Seoul")
                .build();
    }

    @AfterEach
    void after() {
        result = null;
    }

    @Test
    @DisplayName("그냥 변환하면 실패한다.")
    void fail_test() {
        //given
        MultiValueMapTestDto1 dto = MultiValueMapTestDto1.builder()
                .name("name")
                .build();

        //when then
        assertThrows(IllegalArgumentException.class, () -> {
            MultiValueMap<String, String> params = objectMapper.convertValue(dto, new TypeReference<MultiValueMap<String, String>>() {});
        });
    }

    @Test
    @DisplayName("dto를 map으로 변환하는 테스트")
    void dtoToMap() {

        //given
        String testName = "testName";
        long testAmount = 10;
        boolean testChecked = true;

        MultiValueMapTestDto1 dto = MultiValueMapTestDto1.builder()
                .name(testName)
                .amount(testAmount)
                .checked(testChecked)
                .build();

        //when
        Map<String, Object> map = objectMapper.convertValue(dto, new HashMap<String, Object>().getClass());

        //then
        Assertions.assertEquals(testName, map.get("name"));
        Assertions.assertEquals(testAmount, map.get("amount"));
        Assertions.assertEquals(testChecked, map.get("checked"));
    }

    @Test
    @DisplayName("dto를 MultiValueMap으로 변환")
    void dtoToMultiValueMap() {
        //given
        String testName = "testName";
        long testAmount = 10;
        boolean testChecked = true;

        MultiValueMapTestDto1 dto = MultiValueMapTestDto1.builder()
                .name(testName)
                .amount(testAmount)
                .checked(testChecked)
                .build();
    }

    @Test
    @DisplayName("정상적으로 변환된다.")
    void test1() {
        //given
        String expectedName = "name";
        int expectedAmount = 1000;
        boolean expectedChecked = true;
        LocalDateTime expectedDateTime = LocalDateTime.of(2020, 2, 22, 19, 35, 1);
        MultiValueMapTestDto1.Status expectedStatus = SUCCESS;

        MultiValueMapTestDto1 dto = MultiValueMapTestDto1.builder()
                .name(expectedName)
                .amount(expectedAmount)
                .checked(expectedChecked)
                .dateTime(expectedDateTime)
                .status(expectedStatus)
                .build();

        //when
        result = CustomMultiValueMapConverter.convert(objectMapper, dto);

        //then
        assertThat(result.size()).isEqualTo(5);
        assertValue("name", expectedName);
        assertValue("amount", String.valueOf(expectedAmount));
        assertValue("checked", String.valueOf(expectedChecked));
        assertValue("dateTime", LocalDateTimeUtils.toStringDateTime(expectedDateTime));
        assertValue("status", expectedStatus.name());
    }

    private void assertValue(String name, String expectedName) {
        assertThat(getValue(result, name)).isEqualTo(expectedName);
    }

    private String getValue(MultiValueMap<String, String> result, String name) {
        return result.get(name).get(0);
    }
}