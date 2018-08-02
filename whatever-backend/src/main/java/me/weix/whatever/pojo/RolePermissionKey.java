/*
*
* RolePermissionKey.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import me.weix.whatever.base.BasePojo;

@Data
public class RolePermissionKey extends BasePojo {
    private Integer roleId;

    private Integer permissionId;
}