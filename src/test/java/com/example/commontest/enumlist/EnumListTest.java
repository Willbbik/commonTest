package com.example.commontest.enumlist;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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




}
