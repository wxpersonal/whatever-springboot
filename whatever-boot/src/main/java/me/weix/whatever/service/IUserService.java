package me.weix.whatever.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.weix.whatever.entity.User;
import me.weix.whatever.model.UserDto;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
public interface IUserService extends IService<User> {

    /**
     * getUserByEmail
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * getUserByMobile
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * getUserByAccount
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 添加用户
     * @param userDto
     */
    void addUser(UserDto userDto);

    /**
     * 更新用户
     * @param userDto
     */
    void updateUser(UserDto userDto);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     */
    void changePwd(String oldPassword, String newPassword);

    /**
     * 重置密码
     * @param userId
     * @param newPassword
     */
    void resetPwd(Integer userId, String newPassword);

    String testTransaction();



}
