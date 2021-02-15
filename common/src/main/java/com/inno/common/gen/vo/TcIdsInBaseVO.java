package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcIdsInBaseVO extends PageVO {

    
    private String tblNm;// 테이블 명
    
    private Integer nextId;// 다음 ID
    

    public String getTblNm() { return tblNm; }

    public Integer getNextId() { return nextId; }

    public void setTblNm(String tblNm) { this.tblNm = tblNm; }

    public void setNextId(Integer nextId) { this.nextId = nextId; }
}
