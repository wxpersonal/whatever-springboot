package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author weix
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class Role extends BaseEntity {
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