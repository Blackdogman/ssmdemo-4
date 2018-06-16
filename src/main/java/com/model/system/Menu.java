package com.model.system;

import java.util.Date;

public class Menu {
    /**
     * 菜单ID
     */
    private String menuId;
    /** */
    private String pId;

    private String anthortyName;

    private String anthortyDesc;

    private String anthortyUrl;

    private Date createTime;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getAnthortyName() {
        return anthortyName;
    }

    public void setAnthortyName(String anthortyName) {
        this.anthortyName = anthortyName;
    }

    public String getAnthortyDesc() {
        return anthortyDesc;
    }

    public void setAnthortyDesc(String anthortyDesc) {
        this.anthortyDesc = anthortyDesc;
    }

    public String getAnthortyUrl() {
        return anthortyUrl;
    }

    public void setAnthortyUrl(String anthortyUrl) {
        this.anthortyUrl = anthortyUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}