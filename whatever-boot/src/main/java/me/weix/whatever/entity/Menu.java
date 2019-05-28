package me.weix.whatever.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import me.weix.whatever.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author weix
 * @since 2019-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上级菜单
     */
    private Integer pid;

    /**
     * 排序级别
     */
    private String name;

    /**
     * 菜单类型  0 叶  1 非叶菜单
     */
    private Integer kind;

    /**
     * url
     */
    private String url;

    /**
     * icon
     */
    private String icon;

    /**
     * 菜单排序号
     */
    @TableField("sort_no")
    private Integer sortNo;

    /**
     * 菜单层级
     */
    private Integer level;

    /**
     * 备注
     */
    private String desc;

    private List<Menu> children;

}
