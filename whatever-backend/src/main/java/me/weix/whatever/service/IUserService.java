package me.weix.whatever.service;

import com.baomidou.mybatisplus.service.IService;
import me.weix.whatever.pojo.Permission;
import me.weix.whatever.pojo.Role;
import me.weix.whatever.pojo.User;

import java.util.List;

public interface IUserService extends IService<User> {

    List<Role> getRolesByUserId(Integer userId);

    List<Permission> getPermissionsByUserId(Integer userId);

    User getUserByEmail(String email);

    User getUserByMobile(String mobile);

    User getUserByUsername(String username);

    String testTransaction();

}