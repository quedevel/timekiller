package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcComCdBaseVO extends PageVO {

    
    private String cdId;// 코드 아이디
    
    private String supiCdId;// 상위 코드 아이디
    
    private String cdNm;// 코드명
    
    private String cdVal;// 코드값
    
    private String cdOpt1;// 코드 옵션값1
    
    private String cdOpt2;// 코드 옵션값2
    
    private String cdOpt3;// 코드 옵션 값3
    
    private Integer ordr;// 순서
    
    private String useYn;// 사용 여부
    
    private Date regDate;// 등록 일시
    
    private String regSn;// 등록자 일련번호
    
    private Date modDate;// 수정 일시
    
    private String modSn;// 수정자 일련번호
    

    public String getCdId() { return cdId; }

    public String getSupiCdId() { return supiCdId; }

    public String getCdNm() { return cdNm; }

    public String getCdVal() { return cdVal; }

    public String getCdOpt1() { return cdOpt1; }

    public String getCdOpt2() { return cdOpt2; }

    public String getCdOpt3() { return cdOpt3; }

    public Integer getOrdr() { return ordr; }

    public String getUseYn() { return useYn; }

    public Date getRegDate() { return regDate; }

    public String getRegSn() { return regSn; }

    public Date getModDate() { return modDate; }

    public String getModSn() { return modSn; }

    public void setCdId(String cdId) { this.cdId = cdId; }

    public void setSupiCdId(String supiCdId) { this.supiCdId = supiCdId; }

    public void setCdNm(String cdNm) { this.cdNm = cdNm; }

    public void setCdVal(String cdVal) { this.cdVal = cdVal; }

    public void setCdOpt1(String cdOpt1) { this.cdOpt1 = cdOpt1; }

    public void setCdOpt2(String cdOpt2) { this.cdOpt2 = cdOpt2; }

    public void setCdOpt3(String cdOpt3) { this.cdOpt3 = cdOpt3; }

    public void setOrdr(Integer ordr) { this.ordr = ordr; }

    public void setUseYn(String useYn) { this.useYn = useYn; }

    public void setRegDate(Date regDate) { this.regDate = regDate; }

    public void setRegSn(String regSn) { this.regSn = regSn; }

    public void setModDate(Date modDate) { this.modDate = modDate; }

    public void setModSn(String modSn) { this.modSn = modSn; }
}
