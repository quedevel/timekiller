package com.inno.backoffice.menu.vo;

import com.inno.common.gen.vo.TcAdminMenuLsBaseVO;

import java.util.List;

public class MenuVO extends TcAdminMenuLsBaseVO {

    private String link;

    private String authSn;

    private List<String> menuSnList;

    private String[] menuUrlList;

    private String state;

    List<MenuVO> children;

    public String[] getMenuUrlList() {
        return menuUrlList;
    }
    public void setMenuUrlList(String[] menuUrlList) {
        this.menuUrlList = menuUrlList;
    }
    public List<String> getMenuSnList() {
        return menuSnList;
    }
    public void setMenuSnList(List<String> menuSnList) {
        this.menuSnList = menuSnList;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAuthSn() {
        return authSn;
    }
    public void setAuthSn(String authSn) {
        this.authSn = authSn;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public List<MenuVO> getChildren() {
        return children;
    }
    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
