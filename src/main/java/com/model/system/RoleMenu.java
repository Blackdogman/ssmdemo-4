package com.model.system;

public class RoleMenu {
    private String roleMenuId;

    private String roleId;

    private String menuId;

    public RoleMenu(String roleMenuId, String roleId, String menuId) {
        this.roleMenuId = roleMenuId;
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}