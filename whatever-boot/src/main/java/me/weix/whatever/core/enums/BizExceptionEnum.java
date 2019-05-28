package me.weix.whatever.core.enums;

public enum BizExceptionEnum {

    /**
     * 账户问题
     */
    NOT_LOGIN(401, "当前用户未登录"),
    USER_ALREADY_REG(401, "该用户已经注册"),
    NO_THIS_USER(400, "没有此用户"),
    USER_NOT_EXISTED(400, "没有此用户"),
    ACCOUNT_FREEZED(401, "账号被冻结"),
    OLD_PWD_NOT_RIGHT(402, "原密码不正确"),
    TWO_PWD_NOT_MATCH(405, "两次输入密码不一致"),


    /**
     * 密码
     */
    ENCRYPT_ERROR(600, "加解密错误"),

    /**
     * 权限相关
     */
    CANT_DELETE_ADMIN(800, "不能删除超级管理员"),
    NO_PERMITION(801, "权限不足");

    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
