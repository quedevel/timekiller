package com.inno.common.constant;

public enum CommonConstants {
    // 테이블
    TC_ADMIN_MS("A"),
    TC_ADMIN_MENU_LS("M"),

    // DB RESULT MESSAGE
    DB_INSERT_SUCCESS_MESSAGE("성공적으로 등록되었습니다."),
    DB_INSERT_FAILURE_MESSAGE("등록에 실패했습니다."),
    DB_UPDATE_SUCCESS_MESSAGE("성공적으로 수정되었습니다."),
    DB_UPDATE_FAILURE_MESSAGE("수정에 실패했습니다."),
    DB_DELETE_SUCCESS_MESSAGE("성공적으로 삭제되었습니다."),
    DB_DELETE_FAILURE_MESSAGE("삭제에 실패했습니다."),

    // 결과 코드
    SUCCESS_CODE("00"), FAIL_CODE("99"), UNEXPECTED_CODE("44"),

    // 공통 상수
    INNO_ROOT_SN("0000000000"),
    DEFAULT_YES("Y"), DEFAULT_NO("N");

    private final String value;

    public String getValue(){
        return value;
    }

    CommonConstants(String value){
        this.value = value;
    }
}
