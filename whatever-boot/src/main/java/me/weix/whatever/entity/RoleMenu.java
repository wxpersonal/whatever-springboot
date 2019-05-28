package me.weix.whatever.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import me.weix.whatever.core.base.BaseEntity;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 角色菜单关联表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_role_menu")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("role_id")
    private Integer roleId;

    @TableField("menu_id")
    private Integer menuId;
}
