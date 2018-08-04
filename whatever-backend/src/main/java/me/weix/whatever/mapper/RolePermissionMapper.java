/*
*
* RolePermissionMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.pojo.RolePermission;
import me.weix.whatever.pojo.RolePermissionKey;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface RolePermissionMapper {
    int selectByIds(@Param("ids") Integer[] ids);

    int deleteLogicById(Integer id);

    int deleteLogicByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(RolePermissionKey key);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}