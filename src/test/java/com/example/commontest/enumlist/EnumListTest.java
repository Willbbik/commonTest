package com.example.commontest.enumlist;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class EnumListTest {

    @Test
    @DisplayName("기본 enum 목록 출력 테스트")
    void basicEnumList() {
        Map<String, Object> enums = new LinkedHashMap<>();

        Class commissionType = CommissionType.class;
        Class commissionCutting = CommissionCutting.class;

        enums.put("commissionType", commissionType.getEnumConstants());
        enums.put("commissionCutting", commissionCutting.getEnumConstants());

        Gson gson = new Gson();
        String result = gson.toJson(enums);

        System.out.println(result);
    }

    @Test
    void EnumModel타입확인() {

        List<EnumModel> enumModelList = new ArrayList<>();
        enumModelList.add(CommissionType.MONEY);
        enumModelList.add(CommissionCutting.CEIL);

        assertThat(enumModelList.get(0).getValue(), is("money"));
        assertThat(enumModelList.get(1).getValue(), is("ceil"));
    }

    @Test
    void EnumValueDto에값담은후리스트출력하기() {

        Map<String, List<EnumValue>> enumValues = new LinkedHashMap<>();
        enumValues.put("commissionType", toEnumValues(CommissionType.class));
        enumValues.put("commissionCutting", toEnumValues(CommissionCutting.class));

        Gson gson = new Gson();
        String result = gson.toJson(enumValues);
        System.out.println(result);
    }

    private List<EnumValue> toEnumValues(Class<? extends EnumModel> e){
        return Arrays
                .stream(e.getEnumConstants())
                .map(EnumValue::new)
                .collect(Collectors.toList());
    }

}
