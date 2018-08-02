/*
*
* RoleMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface RoleMapper {
    int selectByIds(@Param("ids") Integer[] ids);

    int deleteLogicById(Integer id);

    int deleteLogicByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 在下面添加自定义方法
     */

    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
