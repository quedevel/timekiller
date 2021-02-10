package com.inno.backoffice.admin.vo;

import com.inno.common.gen.vo.TcAdminMsBaseVO;

public class AdminVO extends TcAdminMsBaseVO {

    private String regDateStr;
    private String modDateStr;
    public String getRegDateStr() {
        return regDateStr;
    }
    public void setRegDateStr(String regDateStr) {
        this.regDateStr = regDateStr;
    }
    public String getModDateStr() {
        return modDateStr;
    }
    public void setModDateStr(String modDateStr) {
        this.modDateStr = modDateStr;
    }
}
