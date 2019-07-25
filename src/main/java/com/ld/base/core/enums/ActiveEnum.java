package com.ld.base.core.enums;

/**
 * 有效状态标识
 *
 * @author 王海龙
 */

public enum ActiveEnum {

    EFFECTIVE(1, "有效"),
    INVALID(0, "无效");

    private Integer value;
    private String message;

    ActiveEnum(Integer value, String message) {
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
