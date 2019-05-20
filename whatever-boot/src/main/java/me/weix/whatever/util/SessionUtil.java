package me.weix.whatever.util;

import me.weix.whatever.common.model.UserInfo;
import me.weix.whatever.model.UserDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author : weixiang
 * create at:  2019-05-20
 * @description: sessionUtil
 */
public class SessionUtil {

    private static final String USERINFO = "userInfo";
    private static final String USER = "user";

    public static Subject subject = SecurityUtils.getSubject();

    public  static UserInfo getUserInfo() {
        return (UserInfo) subject.getSession().getAttribute(USERINFO);
    }

    public static UserDto getUser() {
        return getUserInfo().getUser();
    }

    public static Subject getSubject() {
        return subject;
    }
}
