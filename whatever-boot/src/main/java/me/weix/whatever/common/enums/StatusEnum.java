package me.weix.whatever.common.enums;

import lombok.Getter;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 状态枚举
 */
@Getter
public enum StatusEnum {
    /**
     * 状态 有效
     */
    ENABLE(1, "有效"),
    /**
     * 状态 无效
     */
    DISABLE(0, "无效");

    Integer code;
    String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
