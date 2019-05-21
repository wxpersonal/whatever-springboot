package me.weix.whatever.config.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author weix
 * Created by Administrator on 2017/6/19.
 */
public class MobileRealm extends BaseRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return initAuthorInfo(principalCollection);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal = (String) authenticationToken.getPrincipal();
        String credential = new String((char[])authenticationToken.getCredentials());
        return new SimpleAuthenticationInfo(principal, credential, this.getName());
    }
}
