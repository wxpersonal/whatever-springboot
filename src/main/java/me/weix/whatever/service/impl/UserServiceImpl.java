package me.weix.whatever.service.impl;

import me.weix.whatever.mapper.PermissionMapper;
import me.weix.whatever.mapper.RoleMapper;
import me.weix.whatever.mapper.UserMapper;
import me.weix.whatever.pojo.Permission;
import me.weix.whatever.pojo.Role;
import me.weix.whatever.pojo.User;
import me.weix.whatever.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleMapper.getRolesByUserId(userId);
    }

    @Override
    public List<Permission> getPermissionsByUserId(Integer userId) {

        List<Permission> permissionList = new ArrayList<Permission>();
        List<Role> roleList = getRolesByUserId(userId);
        for(Role role : roleList){
            List<Permission> permissions = permissionMapper.getPermissionsByRoleId(role.getId());
            permissionList.addAll(permissions);
        }
        return permissionList;
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }
}
