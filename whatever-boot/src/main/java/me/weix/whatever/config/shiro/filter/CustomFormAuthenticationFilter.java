package me.weix.whatever.config.shiro.filter;

import me.weix.whatever.common.model.UserInfo;
import me.weix.whatever.config.shiro.authc.CustomUsernamePasswordToken;
import me.weix.whatever.entity.User;
import me.weix.whatever.model.UserDto;
import me.weix.whatever.service.IUserService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author weix
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private IUserService userService;

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String account = subject.getPrincipal().toString();
        User user = userService.getUserByAccount(account);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(userDto);
        subject.getSession().setAttribute("userInfo", userInfo);
        return super.onLoginSuccess(token, subject, request, response);
    }
}