package me.weix.whatever.config.shiro.realm;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/19.
 */
public class UsernameRealm extends AuthorizingRealm {


    @Autowired
    @Lazy
    private IUserService userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String principal = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.getUserByUsername(principal);

        //获取用户所有角色
        List<Role> roleList = userService.getRolesByUserId(user.getId());
        Set<String> roles = new HashSet<>();
        for (Role r : roleList) {
            roles.add(r.getCode());
        }

        //获取用户所有权限
        List<Permission> permissionList = userService.getPermissionsByUserId(user.getId());
        Set<String> permissions = new HashSet<>();
        for (Permission p : permissionList) {
            permissions.add(p.getCode());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal = (String) authenticationToken.getPrincipal();
        String credential = new String((char[])authenticationToken.getCredentials());
        // TODO 登录校验
        return new SimpleAuthenticationInfo(principal, credential, this.getName());
    }
}
