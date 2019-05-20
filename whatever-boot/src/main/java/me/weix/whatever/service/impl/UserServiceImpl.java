package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.weix.whatever.common.enums.BizExceptionEnum;
import me.weix.whatever.common.enums.RoleEnum;
import me.weix.whatever.common.model.UserInfo;
import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.mapper.PermissionMapper;
import me.weix.whatever.mapper.RoleMapper;
import me.weix.whatever.mapper.UserMapper;
import me.weix.whatever.model.UserDto;
import me.weix.whatever.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.weix.whatever.util.MD5Util;
import me.weix.whatever.util.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户表 服务实现类
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
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByMobile(String mobile) {
        return null;
    }

    @Override
    public User getUserByAccount(String account) {
        User user = baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getAccount, account));
        return user;
    }

    @Override
    public void addUser(UserDto userDto) {

        User exist = baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getAccount, userDto.getAccount()));
        if (null != exist) {
            throw new RuntimeException(BizExceptionEnum.USER_ALREADY_REG.getMessage());
        }

        //生成加密盐
        String salt = MD5Util.getRandomString(5);
        String password = MD5Util.md5(userDto.getPassword(), salt);
        userDto.setPassword(password);
        User user = initUser(userDto);
        save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        // 超级管理员可以修改所有信息
        if (SecurityUtils.getSubject().hasRole(RoleEnum.ADMIN.getCode())) {
            updateById(initUser(userDto));
            // 其他情况只可以修改自己
        } else {
            UserDto user = SessionUtil.getUser();
            if (user.getId().equals(userDto.getId())) {
                this.updateById(initUser(userDto));
            } else {
                throw new RuntimeException(BizExceptionEnum.NO_PERMITION.getMessage());
            }
        }
    }

    @Override
    public void deleteUser(Integer id) {
        List<Role> roles = roleMapper.getRolesByUserId(id);
        List<String> roleCodes = roles.stream().distinct().map(Role::getCode).collect(Collectors.toList());
        if (roleCodes.contains(RoleEnum.ADMIN.getCode())) {
            throw new RuntimeException(BizExceptionEnum.CANT_DELETE_ADMIN.getMessage());
        }
        if (SecurityUtils.getSubject().hasRole(RoleEnum.ADMIN.getCode())) {
            baseMapper.deleteById(id);
        } else {
            throw new RuntimeException(BizExceptionEnum.NO_PERMITION.getMessage());
        }
    }

    @Override
    public void changePwd(String oldPassword, String newPassword) {
        UserDto user = SessionUtil.getUser();
        User u = baseMapper.selectById(user.getId());
        String oldMD5 = MD5Util.md5(oldPassword, user.getSalt());
        if (user.getPassword().equals(oldMD5)) {
            String newMD5 = MD5Util.md5(newPassword, user.getSalt());
            u.setPassword(newMD5);
            baseMapper.updateById(u);
        } else {
            throw new RuntimeException(BizExceptionEnum.OLD_PWD_NOT_RIGHT.getMessage());
        }
    }

    @Override
    public void resetPwd(Integer userId, String newPassword) {
        if (SecurityUtils.getSubject().hasRole(RoleEnum.ADMIN.getCode())) {
            User user = baseMapper.selectById(userId);
            String newMD5 = MD5Util.md5(newPassword, user.getSalt());
            user.setPassword(newMD5);
            baseMapper.updateById(user);
        } else {
            throw new RuntimeException(BizExceptionEnum.NO_PERMITION.getMessage());
        }
    }


    @Override
    @Transactional
    public String testTransaction() {

        User user = baseMapper.selectById(1);
        user.setStatus((user.getStatus() + 1) % 5);
        baseMapper.updateById(user);

        int i = 3 / 0;
        return "111111111";
    }

    private User initUser(UserDto user) {
        User u = new User();
        BeanUtils.copyProperties(user, u);
        return u;
    }

}
