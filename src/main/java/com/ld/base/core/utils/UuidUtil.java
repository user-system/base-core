package com.ld.base.core.utils;

import java.util.UUID;

/**
 * uuid生成工具
 *
 * @author 王海龙
 */
public class UuidUtil {

    /**
     * 获取uuid
     */
    public static String getUuid32() {
        return UUID.randomUUID().toString();
    }

}
