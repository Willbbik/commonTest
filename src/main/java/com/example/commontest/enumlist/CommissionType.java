package com.example.commontest.enumlist;

public enum CommissionType {

    PERCENT("percent"),
    MONEY("money");

    private String value;

    CommissionType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }


}
