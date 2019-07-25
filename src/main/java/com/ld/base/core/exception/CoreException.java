package com.ld.base.core.exception;

/**
 * 通用异常
 *
 * @author 王海龙
 */
public class CoreException extends Exception {

    private static final long serialVersionUID = 5064660763477293806L;

    private CoreException exeptionEnum;

    public CoreException() {
        super();
    }

    public CoreException(CoreException exeptionEnum) {
        super();
        this.exeptionEnum = exeptionEnum;
    }

    public Integer getCode() {
        return exeptionEnum.getCode();
    }

    @Override
    public String getMessage() {
        return exeptionEnum.getMessage();
    }

}
