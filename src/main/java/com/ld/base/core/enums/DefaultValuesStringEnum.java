package com.ld.base.core.enums;

/**
 * 默认值为字符串的定义
 *
 * @author 王海龙
 */

public enum DefaultValuesStringEnum {

    ORG_PARENT_UUID("0", "组织默认的父级UUID"),
    MENU_PARENT_UUID("0", "菜单默认的父级UUID"),
    ROLE_PARENT_UUID("0", "角色默认的父级UUID");

    private String value;
    private String message;

    DefaultValuesStringEnum(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getMessage() {
        return this.message;
    }

}
