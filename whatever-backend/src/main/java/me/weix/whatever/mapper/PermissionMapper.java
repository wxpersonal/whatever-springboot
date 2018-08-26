/*
*
* PermissionMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.SuperMapper;
import me.weix.whatever.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface PermissionMapper extends SuperMapper<Permission> {
    /**
     * 在下面添加自定义方法
     */

    List<Permission> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}