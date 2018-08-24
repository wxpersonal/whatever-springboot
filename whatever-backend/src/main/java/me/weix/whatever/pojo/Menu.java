/*
*
* Menu.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Menu extends BasePojo {
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

}