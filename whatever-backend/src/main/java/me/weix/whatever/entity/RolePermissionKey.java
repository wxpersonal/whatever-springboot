package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author weix
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class RolePermissionKey extends BaseEntity {
    private Integer roleId;

    private Integer permissionId;
}