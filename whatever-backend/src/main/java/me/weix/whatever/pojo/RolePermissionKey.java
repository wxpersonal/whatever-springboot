/*
*
* RolePermissionKey.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RolePermissionKey extends BasePojo {
    private Integer roleId;

    private Integer permissionId;
}