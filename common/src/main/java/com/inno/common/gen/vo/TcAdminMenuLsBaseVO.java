package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcAdminMenuLsBaseVO extends PageVO {
    
    private String menuSn;   // 메뉴 일련번호
    
    private String supiMenuSn;   // 상위 메뉴 일련번호
    
    private String menuNm;   // 메뉴명
    
    private String menuUrl;   // 메뉴 URL
    
    private int dept;   // 메뉴 깊이
    
    private int ordr;   // 메뉴 순서
    
    private String useYn;   // 사용 여부
    
    private String expYn;   // 노출 여부
    
    private Date regDate;   // 등록 일시
    
    private String regSn;   // 등록자 일련번호
    
    private Date modDate;   // 수정 일시
    
    private String modSn;   // 수정자 일련번호
    
    public String getMenuSn() { return menuSn; }
    public String getSupiMenuSn() { return supiMenuSn; }
    public String getMenuNm() { return menuNm; }
    public String getMenuUrl() { return menuUrl; }
    public int getDept() { return dept; }
    public int getOrdr() { return ordr; }
    public String getUseYn() { return useYn; }
    public String getExpYn() { return expYn; }
    public Date getRegDate() { return regDate; }
    public String getRegSn() { return regSn; }
    public Date getModDate() { return modDate; }
    public String getModSn() { return modSn; }
    public void setMenuSn(String menuSn) { this.menuSn = menuSn; }
    public void setSupiMenuSn(String supiMenuSn) { this.supiMenuSn = supiMenuSn; }
    public void setMenuNm(String menuNm) { this.menuNm = menuNm; }
    public void setMenuUrl(String menuUrl) { this.menuUrl = menuUrl; }
    public void setDept(int dept) { this.dept = dept; }
    public void setOrdr(int ordr) { this.ordr = ordr; }
    public void setUseYn(String useYn) { this.useYn = useYn; }
    public void setExpYn(String expYn) { this.expYn = expYn; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }
    public void setRegSn(String regSn) { this.regSn = regSn; }
    public void setModDate(Date modDate) { this.modDate = modDate; }
    public void setModSn(String modSn) { this.modSn = modSn; }
}

