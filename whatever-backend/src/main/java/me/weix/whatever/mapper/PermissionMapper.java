/*
*
* PermissionMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface PermissionMapper {
    int selectByIds(@Param("ids") Integer[] ids);

    int deleteLogicById(Integer id);

    int deleteLogicByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 在下面添加自定义方法
     */

    List<Permission> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}