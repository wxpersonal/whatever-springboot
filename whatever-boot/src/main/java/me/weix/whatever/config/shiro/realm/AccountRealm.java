package me.weix.whatever.config.shiro.realm;

import me.weix.whatever.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author weix
 * Created by Administrator on 2017/6/19.
 */
public class AccountRealm extends BaseRealm {

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return initAuthorInfo(principalCollection);
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
        User user = userService.getUserByAccount(principal);
        String salt = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(salt);
        return new SimpleAuthenticationInfo(principal, user.getPassword(), credentialsSalt, this.getName());
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        md5CredentialsMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }

}
