package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author weix
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserRoleKey extends BaseEntity {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色code
     */
    private Integer roleId;
}