//package com.example.commontest.enumlist;
//
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//class EnumListTest {
//
//    @MockBean
//    private EnumMapper enumMapper;
//
//    @BeforeEach
//    void beforeSetup(){
//        enumMapper = new EnumMapper();
//        enumMapper.put("commissionType", CommissionType.class);
//        enumMapper.put("commissionCutting", CommissionCutting.class);
//    }
//
//
//    @Test
//    void 기본enum목록출력테스트() {
//        Map<String, Object> enums = new LinkedHashMap<>();
//
//        Class commissionType = CommissionType.class;
//        Class commissionCutting = CommissionCutting.class;
//
//        enums.put("commissionType", commissionType.getEnumConstants());
//        enums.put("commissionCutting", commissionCutting.getEnumConstants());
//
//        Gson gson = new Gson();
//        String result = gson.toJson(enums);
//        System.out.println(result);
//    }
//
//    @Test
//    void EnumModel타입확인() {
//        List<EnumModel> enumModelList = new ArrayList<>();
//        enumModelList.add(CommissionType.MONEY);
//        enumModelList.add(CommissionCutting.CEIL);
//
//        assertThat(enumModelList.get(0).getValue(), is("money"));
//        assertThat(enumModelList.get(1).getValue(), is("ceil"));
//    }
//
//    @Test
//    void EnumValueDto에값담은후리스트출력하기() {
//
//        Map<String, List<EnumValue>> enumValues = new LinkedHashMap<>();
//        enumValues.put("commissionType", toEnumValues(CommissionType.class));
//        enumValues.put("commissionCutting", toEnumValues(CommissionCutting.class));
//
//        Gson gson = new Gson();
//        String result = gson.toJson(enumValues);
//        System.out.println(result);
//    }
//
//
//    @Test
//    void enum을List로변환해주는공통모듈의사용결과를출력한다() {
//        Map<String, List<EnumValue>> enumValues = enumMapper.getAll();
//
//        Gson gson = new Gson();
//        String result = gson.toJson(enumValues);
//        System.out.println(result);
//    }
//
//    private List<EnumValue> toEnumValues(Class<? extends EnumModel> e) {
//        return Arrays
//                .stream(e.getEnumConstants())
//                .map(EnumValue::new)
//                .collect(Collectors.toList());
//    }
//
//}
