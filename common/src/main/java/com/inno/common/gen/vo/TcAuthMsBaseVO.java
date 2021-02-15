package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcAuthMsBaseVO extends PageVO {

    
    private String authSn;// 권한 일련번호
    
    private String authNm;// 권한명
    
    private String useYn;// 사용 여부
    
    private Date regDate;// 등록 일시
    
    private String regSn;// 등록자 일련번호
    
    private Date modDate;// 수정 일시
    
    private String modSn;// 수정자 일련번호
    

    public String getAuthSn() { return authSn; }

    public String getAuthNm() { return authNm; }

    public String getUseYn() { return useYn; }

    public Date getRegDate() { return regDate; }

    public String getRegSn() { return regSn; }

    public Date getModDate() { return modDate; }

    public String getModSn() { return modSn; }

    public void setAuthSn(String authSn) { this.authSn = authSn; }

    public void setAuthNm(String authNm) { this.authNm = authNm; }

    public void setUseYn(String useYn) { this.useYn = useYn; }

    public void setRegDate(Date regDate) { this.regDate = regDate; }

    public void setRegSn(String regSn) { this.regSn = regSn; }

    public void setModDate(Date modDate) { this.modDate = modDate; }

    public void setModSn(String modSn) { this.modSn = modSn; }
}
