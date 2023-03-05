package com.example.commontest.enumlist;

public enum CommissionCutting implements EnumModel {

    ROUND("round"),
    CEIL("ceil"),
    FLOOR("floor");

    private String value;

    CommissionCutting(String value) {
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
