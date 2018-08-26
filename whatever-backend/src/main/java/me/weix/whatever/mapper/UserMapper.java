/*
*
* UserMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.SuperMapper;
import me.weix.whatever.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface UserMapper extends SuperMapper<User> {

    User getUserByMobile(@Param("mobile") String mobile);

    User getUserByEmail(@Param("email") String email);

    User getUserByUsername(@Param("username") String username);
}