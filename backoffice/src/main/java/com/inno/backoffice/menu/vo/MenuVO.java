package com.inno.backoffice.menu.vo;

import com.inno.common.gen.vo.TcAdminMenuLsBaseVO;

import java.util.List;

public class MenuVO extends TcAdminMenuLsBaseVO {

    List<MenuVO> children;

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
