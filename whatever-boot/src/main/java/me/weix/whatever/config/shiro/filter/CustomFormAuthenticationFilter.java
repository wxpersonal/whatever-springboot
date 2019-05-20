package me.weix.whatever.config.shiro.filter;

import me.weix.whatever.config.shiro.authc.CustomUsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 重写该方法,为了将loginType参数保存到token中
     *
     * @param request  请求
     * @param response 响应
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        Integer loginType = Integer.parseInt(getLoginType(request));
        return createToken(username, password, request, response, loginType);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        // todo 将用户公司等信息保存到session
        return super.onLoginSuccess(token, subject, request, response);
    }

    private AuthenticationToken createToken(String username, String password, ServletRequest request, ServletResponse response, Integer loginType) {
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return createToken(username, password, rememberMe, host, loginType);
    }

    private AuthenticationToken createToken(String username, String password, boolean rememberMe, String host, Integer loginType) {

        return new CustomUsernamePasswordToken(username, password, rememberMe, host, loginType);
    }

    private AuthenticationToken createToken(String username, String password, Integer loginType) {
        return new CustomUsernamePasswordToken(username, password, loginType);
    }

    private String getLoginType(ServletRequest request) {
        return WebUtils.getCleanParam(request, "loginType");
    }


}