package com.ld.base.core.vo;

import lombok.Data;

/**
 * 统一返回结果
 *
 * @author 王海龙
 */
@Data
public class ResultVo<T> {

    /**
     * 返回结果代码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    T data;

}
