package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcAdminMsBaseVO extends PageVO {

    
    private String adminSn;// 관리자 일련번호
    
    private String adminId;// 관리자 ID
    
    private String adminPw;// 관리자 PW
    
    private String adminNm;// 관리자 명
    
    private String useYn;// 사용 여부
    
    private Date regDate;// 등록 일시
    
    private String regSn;// 등록자 일련번호
    
    private Date modDate;// 수정 일시
    
    private String modSn;// 수정자 일련번호
    

    public String getAdminSn() { return adminSn; }

    public String getAdminId() { return adminId; }

    public String getAdminPw() { return adminPw; }

    public String getAdminNm() { return adminNm; }

    public String getUseYn() { return useYn; }

    public Date getRegDate() { return regDate; }

    public String getRegSn() { return regSn; }

    public Date getModDate() { return modDate; }

    public String getModSn() { return modSn; }

    public void setAdminSn(String adminSn) { this.adminSn = adminSn; }

    public void setAdminId(String adminId) { this.adminId = adminId; }

    public void setAdminPw(String adminPw) { this.adminPw = adminPw; }

    public void setAdminNm(String adminNm) { this.adminNm = adminNm; }

    public void setUseYn(String useYn) { this.useYn = useYn; }

    public void setRegDate(Date regDate) { this.regDate = regDate; }

    public void setRegSn(String regSn) { this.regSn = regSn; }

    public void setModDate(Date modDate) { this.modDate = modDate; }

    public void setModSn(String modSn) { this.modSn = modSn; }
}
