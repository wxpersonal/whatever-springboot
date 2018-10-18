/*
*
* UserMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import me.weix.whatever.entity.User;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface UserMapper extends BaseMapper<User> {

    User getUserByMobile(@Param("mobile") String mobile);

    User getUserByEmail(@Param("email") String email);

    User getUserByUsername(@Param("username") String username);
}