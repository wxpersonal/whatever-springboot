/*
*
* User.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
public class User extends BasePojo {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 出生时间
     */
    private Date birthday;

    /**
     * 邮箱
     */
    private String email;

    private Integer addressId;

    /**
     * 照片附件
     */
    private Integer photoId;

}