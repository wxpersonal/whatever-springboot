package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author weix
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class SysCode extends BaseEntity {
    private String code;

    private String pCode;

    private String name;

    private String desc;

}