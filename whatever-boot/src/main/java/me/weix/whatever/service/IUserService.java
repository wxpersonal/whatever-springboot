package me.weix.whatever.service;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
public interface IUserService extends IService<User> {

    List<Role> getRolesByUserId(Integer userId);

    List<Permission> getPermissionsByUserId(Integer userId);

    User getUserByEmail(String email);

    User getUserByMobile(String mobile);

    User getUserByUsername(String username);

    String testTransaction();



}
