/*
*
* RoleMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import me.weix.whatever.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 在下面添加自定义方法
     */

    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
