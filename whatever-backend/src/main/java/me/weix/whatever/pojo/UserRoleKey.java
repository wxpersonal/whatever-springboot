/*
*
* UserRoleKey.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import me.weix.whatever.base.BasePojo;

@Data
public class UserRoleKey extends BasePojo {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色code
     */
    private Integer roleId;
}