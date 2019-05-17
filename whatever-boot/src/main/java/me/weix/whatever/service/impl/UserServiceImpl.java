package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.mapper.PermissionMapper;
import me.weix.whatever.mapper.RoleMapper;
import me.weix.whatever.mapper.UserMapper;
import me.weix.whatever.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

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


        PageHelper.startPage(1, 10);
        List<Permission> permissionList = new ArrayList<Permission>();
        List<Role> roleList = getRolesByUserId(userId);
        for (Role role : roleList) {
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

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    @Transactional
    public String testTransaction() {

        User user = userMapper.selectById(1);
        user.setStatus((user.getStatus() + 1) % 5);
        userMapper.updateById(user);

        int i = 3 / 0;
        return  "111111111";

    }
}
