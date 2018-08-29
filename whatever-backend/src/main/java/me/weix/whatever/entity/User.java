/*
*
* User.java
* @date 2018-08-02
*/
package me.weix.whatever.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@TableName("t_user")
@ApiModel(value="user对象",description="用户对象user")

public class User extends BaseEntity {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */

    @ApiModelProperty(value="用户名",name="username",required = true)
    private String username;


    /**
     * 密码
     */
    @ApiModelProperty(value="密码",name="password",required = true)
    private String password;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别",name="gender",required = true)
    private Integer gender;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话",name="mobile")
    private String mobile;

    /**
     * 出生时间
     */
    @ApiModelProperty(value="出生时间",name="birthday",dataType="date", example = "2018-08-29 12:00:00")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @TableField("address_id")
    private Integer addressId;

    /**
     * 照片附件
     */
    @TableField("photo_id")
    private Integer photoId;

}