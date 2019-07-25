package com.ld.base.core.enums;

/**
 * 默认值为整型的定义
 *
 * @author 王海龙
 */
public enum DefaultValuesIntegerEnum {

    ROLE_ORG_SOURCE(0, "角色的组织创建来源");

    private Integer value;
    private String message;

    DefaultValuesIntegerEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final String getMessage() {
        return this.message;
    }
}
