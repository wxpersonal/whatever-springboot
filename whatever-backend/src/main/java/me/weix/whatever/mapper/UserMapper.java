/*
*
* UserMapper.java
* @date 2018-08-02
*/
package me.weix.whatever.mapper;

import me.weix.whatever.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/08/02
*/
public interface UserMapper {
    int selectByIds(@Param("ids") Integer[] ids);

    int deleteLogicById(Integer id);

    int deleteLogicByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 在下面添加自定义方法
     */
    User getUserByMobile(@Param("mobile") String mobile);

    User getUserByEmail(@Param("email") String email);

    User getUserByUsername(@Param("username") String username);
}