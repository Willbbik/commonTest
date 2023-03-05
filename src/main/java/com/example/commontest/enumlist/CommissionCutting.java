package com.example.commontest.enumlist;

public enum CommissionCutting {

    ROUND("round"),
    CEIL("ceil"),
    FLOOR("floor");

    private String value;

    CommissionCutting(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
