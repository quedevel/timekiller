CREATE TABLE bootex.TC_ADMIN_MS (
    ADMIN_SN int auto_increment NOT NULL COMMENT '관리자 일련번호',
    ADMIN_ID varchar(100) NOT NULL COMMENT '관리자 ID',
    ADMIN_PW varchar(100) NOT NULL COMMENT '관리자 PW',
    ADMIN_NM varchar(100) NOT NULL COMMENT '관리자 명',
    USE_YN varchar(100) NULL COMMENT '사용 여부',
    REG_DATE TIMESTAMP NULL COMMENT '등록 일시',
    REG_SN varchar(100) NULL COMMENT '등록자 일련번호',
    MOD_DATE TIMESTAMP NULL COMMENT '수정 일시',
    MOD_SN varchar(100) NULL COMMENT '수정자 일련번호',
    CONSTRAINT TC_ADMIN_MS_pk PRIMARY KEY (ADMIN_SN)
)ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;