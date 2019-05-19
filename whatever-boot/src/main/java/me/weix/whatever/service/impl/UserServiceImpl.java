package me.weix.whatever.service.impl;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.mapper.PermissionMapper;
import me.weix.whatever.mapper.RoleMapper;
import me.weix.whatever.mapper.UserMapper;
import me.weix.whatever.model.UserDto;
import me.weix.whatever.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Permission> getPermissionsByUserId(Integer userId) {

//        List<Permission> permissionList = new ArrayList<>();
//        List<Role> roleList = getRolesByUserId(userId);
//        for (Role role : roleList) {
//            List<Permission> permissions = permissionMapper.getPermissionsByRoleId(role.getId());
//            permissionList.addAll(permissions);
//        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByMobile(String mobile) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void addUser(UserDto userDto) {

    }

    @Override
    public void updateUser(UserDto user) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void changePwd(String oldPassword, String newPassword) {

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
