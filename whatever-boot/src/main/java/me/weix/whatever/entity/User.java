package me.weix.whatever.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import me.weix.whatever.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author weix
 * @since 2019-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String name;

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

    @TableField("address_id")
    private Integer addressId;

    /**
     * 照片附件
     */
    @TableField("photo_id")
    private Integer photoId;


}
