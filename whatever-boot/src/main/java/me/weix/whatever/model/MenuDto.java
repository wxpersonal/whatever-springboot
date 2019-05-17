package me.weix.whatever.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Data
public class MenuDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 菜单类型  0菜单实例(默认),1菜单分组
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
    private Integer sortNo;

    /**
     * 菜单层级
     */
    private Integer level;

    /**
     * 备注
     */
    private String desc;


}
