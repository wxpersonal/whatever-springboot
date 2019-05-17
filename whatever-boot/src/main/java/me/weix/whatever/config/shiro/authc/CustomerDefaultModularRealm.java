package me.weix.whatever.config.shiro.authc;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Collection;
import java.util.Map;

/**
 * @author weix
 * 重写模块化用户验证器,根据登录界面传递的loginType参数,获取唯一匹配的realm
 */
public class CustomerDefaultModularRealm extends ModularRealmAuthenticator {

    private Map<String, Object> definedRealms;

    /**
     * 调用单个realm执行操作
     */
    @Override
    protected AuthenticationInfo doSingleRealmAuthentication(Realm realm, AuthenticationToken token) {

        if (!realm.supports(token)) {
            throw new ShiroException("token错误!");
        }
        AuthenticationInfo info = realm.getAuthenticationInfo(token);

        if (info == null) {
            throw new ShiroException("token不存在!");
        }
        return info;
    }

    /**
     * 多个realm实现
     */
    @Override
    protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {
        return super.doMultiRealmAuthentication(realms, token);
    }

    /**
     * 判断登录类型执行操作
     */
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {

        this.assertRealmsConfigured();
        Realm realm = null;
        CustomUsernamePasswordToken token = (CustomUsernamePasswordToken) authenticationToken;

        // 邮箱登录
        if (token.getLoginType() == 1) {
            realm = (Realm) this.definedRealms.get("emailRealm");
        }

        // 手机登录
        if (token.getLoginType() == 2) {
            realm = (Realm) this.definedRealms.get("mobileRealm");
        }

        // 用户名登录
        if (token.getLoginType() == 3) {
            realm = (Realm) this.definedRealms.get("usernameRealm");
        }
        return this.doSingleRealmAuthentication(realm, authenticationToken);
    }

    /**
     * 判断realm是否为空
     */
    @Override
    protected void assertRealmsConfigured() throws IllegalStateException {
        this.definedRealms = this.getDefinedRealms();
        if (this.definedRealms == null || this.definedRealms.isEmpty()) {
            throw new ShiroException("值传递错误!");
        }
    }

    public Map<String, Object> getDefinedRealms() {
        return this.definedRealms;
    }

    public void setDefinedRealms(Map<String, Object> definedRealms) {
        this.definedRealms = definedRealms;
    }
}
