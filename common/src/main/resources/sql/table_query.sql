CREATE TABLE bootex.TC_ADMIN_MS (
    ADMIN_SN varchar(10) NOT NULL COMMENT '관리자 일련번호',
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

CREATE TABLE bootex.TC_IDS_IN (
    TBL_NM VARCHAR(100) NOT NULL COMMENT '테이블 명',
    NEXT_ID int NOT NULL COMMENT '다음 ID',
    CONSTRAINT TC_IDS_IN_pk PRIMARY KEY (TBL_NM)
)ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE bootex.TC_ADMIN_MENU_LS (
  MENU_SN VARCHAR(10) NOT NULL COMMENT '메뉴 일련번호',
  SUPI_MENU_SN VARCHAR(10) NOT NULL COMMENT '상위 메뉴 일련번호',
  MENU_NM VARCHAR(100) COMMENT '메뉴명',
  MENU_URL VARCHAR(100) COMMENT '메뉴 URL',
  DEPT INT COMMENT '메뉴 깊이',
  ORDR INT COMMENT '메뉴 순서',
  USE_YN varchar(1) NULL COMMENT '사용 여부',
  DSP_YN varchar(1) NULL COMMENT '노출 여부',
  REG_DATE TIMESTAMP NULL COMMENT '등록 일시',
  REG_SN varchar(100) NULL COMMENT '등록자 일련번호',
  MOD_DATE TIMESTAMP NULL COMMENT '수정 일시',
  MOD_SN varchar(100) NULL COMMENT '수정자 일련번호',
  CONSTRAINT TC_ADMIN_MENU_LS_pk PRIMARY KEY (MENU_SN)
)ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;