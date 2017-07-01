package me.weix.whatever.mapper;

import me.weix.whatever.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
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