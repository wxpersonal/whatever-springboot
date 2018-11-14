package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author weix
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class Permission extends BaseEntity {
    private Integer id;

    private Integer pId;

    private Integer systemId;

    private String code;

    private String desc;

    private String url;

    private Integer orders;

}