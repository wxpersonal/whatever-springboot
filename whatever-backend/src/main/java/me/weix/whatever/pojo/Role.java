/*
*
* Role.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Role extends BasePojo {
    private Integer id;

    /**
     * 权限编码
     */
    private String code;

    private String name;

    /**
     * 权限说明
     */
    private String desc;

}