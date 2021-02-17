package com.inno.common.gen.vo;

import java.util.Date;
import com.inno.common.vo.PageVO;

public class TcAuthMenuMppgLsBaseVO extends PageVO {

    
    private String authSn;// 권한 일련번호
    
    private String menuSn;// 메뉴 일련번호
    
    private Date regDate;// 등록 일시
    
    private String regSn;// 등록자 일련번호
    

    public String getAuthSn() { return authSn; }

    public String getMenuSn() { return menuSn; }

    public Date getRegDate() { return regDate; }

    public String getRegSn() { return regSn; }

    public void setAuthSn(String authSn) { this.authSn = authSn; }

    public void setMenuSn(String menuSn) { this.menuSn = menuSn; }

    public void setRegDate(Date regDate) { this.regDate = regDate; }

    public void setRegSn(String regSn) { this.regSn = regSn; }
}
