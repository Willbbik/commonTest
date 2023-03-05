package com.example.commontest.enumlist;

public enum CommissionType implements EnumModel {

    PERCENT("percent"),
    MONEY("money");

    private String value;

    CommissionType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }




}
