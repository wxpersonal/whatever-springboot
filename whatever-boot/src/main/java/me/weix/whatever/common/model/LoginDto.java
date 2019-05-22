package me.weix.whatever.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : weixiang
 * create at:  2019-05-22
 * @description: 登录接收参数类
 */
@Data
public class LoginDto implements Serializable {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;


    // todo 待扩展

    /**
     * 验证码
     */
    private String verificationCode;

    /**
     * 短信验证码
     */
    private String SMSCode;

    /**
     * 登录类型
     */
    private Integer loginType;

}
