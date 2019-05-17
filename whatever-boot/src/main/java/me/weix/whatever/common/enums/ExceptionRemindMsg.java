package me.weix.whatever.common.enums;

import lombok.Getter;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 异常提示信息枚举
 */
@Getter
public enum  ExceptionRemindMsg {

    /**
     * 非法参数
     */
    INCOMPLETE_PARAM(1000, "请求参数不完整或格式错误!"),

    /**
     * 数据变动
     */
    DATA_CHANGED(1001, "数据有改变，请刷新后重试!");

    private Integer code;
    private String message;

    ExceptionRemindMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
