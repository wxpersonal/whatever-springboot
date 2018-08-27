package me.weix.whatever.service;

import com.baomidou.mybatisplus.service.IService;
import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    List<Role> getRolesByUserId(Integer userId);

    List<Permission> getPermissionsByUserId(Integer userId);

    User getUserByEmail(String email);

    User getUserByMobile(String mobile);

    User getUserByUsername(String username);

    String testTransaction();

}
