package me.weix.whatever.controller;

import me.weix.whatever.common.model.LoginDto;
import me.weix.whatever.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : weixiang
 * create at:  2019-05-22
 * @description: 登录控制器
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String login(@RequestBody LoginDto dto){
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getAccount(), dto.getPassword().toCharArray());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        boolean admin = subject.hasRole("admin");
        subject.getPrincipal();
        subject.hasRole()
        return admin+"";
    }

    @RequestMapping(value="logout", method=RequestMethod.POST)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();



        return "ok";
    }


}
