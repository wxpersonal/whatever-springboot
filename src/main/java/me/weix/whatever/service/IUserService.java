package me.weix.whatever.service;

import me.weix.whatever.pojo.Permission;
import me.weix.whatever.pojo.Role;
import me.weix.whatever.pojo.User;

import java.util.List;

public interface IUserService extends IBaseService<User> {

    List<Role> getRolesByUserId(Integer userId);

    List<Permission> getPermissionsByUserId(Integer userId);

    User getUserByEmail(String email);

    User getUserByMobile(String mobile);

}
