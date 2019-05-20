package me.weix.whatever.config.shiro.realm;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.entity.Role;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/6/19.
 */
public class AccountRealm extends AuthorizingRealm {


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
        User user = userService.getUserByAccount(principal);

        //获取用户所有角色
        List<Role> roleList = userService.getRolesByUserId(user.getId());
        Set<String> roles = new HashSet<>();
        roles.addAll(roleList.stream().distinct().map(Role::getCode).collect(Collectors.toList()));

        //获取用户所有权限
        List<Permission> permissionList = userService.getPermissionsByUserId(user.getId());
        Set<String> permissions = new HashSet<>();
        for (Permission p : permissionList) {
            permissions.add(p.getName());
        }
        permissions.addAll(permissionList.stream().distinct().map(o -> o.getCode()).collect(Collectors.toList()));

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
        User user = userService.getUserByAccount(principal);
        String salt = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(salt);
        return new SimpleAuthenticationInfo(principal, credential, credentialsSalt, this.getName());
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }
}
