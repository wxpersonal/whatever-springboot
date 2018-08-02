/*
*
* UserRoleMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.pojo.UserRole;
import me.weix.whatever.pojo.UserRoleKey;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface UserRoleMapper {
    int selectByIds(@Param("ids") Integer[] ids);

    int deleteLogicById(Integer id);

    int deleteLogicByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(UserRoleKey key);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}