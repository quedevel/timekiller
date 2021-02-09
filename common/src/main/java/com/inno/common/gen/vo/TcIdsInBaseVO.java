package com.inno.common.gen.vo;

import com.inno.common.vo.PageVO;

public class TcIdsInBaseVO extends PageVO {
    
    private String tblNm;   // 테이블 명
    
    private int nextId;   // 다음 ID
    
    public String getTblNm() { return tblNm; }
    public int getNextId() { return nextId; }
    public void setTblNm(String tblNm) { this.tblNm = tblNm; }
    public void setNextId(int nextId) { this.nextId = nextId; }
}

