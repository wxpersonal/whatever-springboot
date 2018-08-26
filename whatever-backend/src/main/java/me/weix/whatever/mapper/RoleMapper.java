/*
*
* RoleMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.SuperMapper;
import me.weix.whatever.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface RoleMapper extends SuperMapper<Role> {

    /**
     * 在下面添加自定义方法
     */

    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
