package com.inno.common.constant;

public enum CommonConstants {

    TC_ADMIN_MS("A"),

    DEFAULT_YES("Y"), DEFAULT_NO("N");

    private final String value;

    public String getValue(){
        return value;
    }

    CommonConstants(String value){
        this.value = value;
    }
}
