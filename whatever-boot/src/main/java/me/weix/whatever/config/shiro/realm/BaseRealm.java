package me.weix.whatever.config.shiro.realm;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IPermissionService;
import me.weix.whatever.service.IRoleService;
import me.weix.whatever.service.IUserService;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : weixiang
 * create at:  2019-05-20
 * @description:
 */
public abstract class BaseRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    protected IUserService userService;

    @Autowired
    @Lazy
    protected IRoleService roleService;

    @Autowired
    @Lazy
    protected IPermissionService permissionService;
    /**
     * 初始化SimpleAuthorizationInfo
     * @return
     */
    public SimpleAuthorizationInfo initAuthorInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String principal = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.getUserByAccount(principal);

        //获取用户所有角色
        List<Role> roleList = roleService.getRolesByUserId(user.getId());
        Set<String> roles = new HashSet<>(roleList.stream().distinct().map(Role::getCode).collect(Collectors.toList()));

        //获取用户所有权限
        List<Permission> permissionList = permissionService.getPermissionsByUserId(user.getId());
        Set<String> permissions = new HashSet<>(permissionList.stream().distinct().map(Permission::getCode).collect(Collectors.toList()));

        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
