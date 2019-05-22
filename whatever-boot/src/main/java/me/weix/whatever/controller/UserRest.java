package me.weix.whatever.controller;

import me.weix.whatever.entity.User;
import me.weix.whatever.model.UserDto;
import me.weix.whatever.service.IUserService;
import me.weix.whatever.util.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Random;


/**
 * @author weix
 */
@RestController
@RequestMapping("user")
public class UserRest {

    @Autowired
    private IUserService userService;

    /**
     * 根据id获取user
     * @param id userId
     * @return me.weix.whatever.entity.User
     */
    @RequestMapping(value="{id}", method=RequestMethod.GET, produces = "application/json")
    @Transactional
    public User getUserById(@PathVariable("id") Integer id) {
        System.out.println("11111113333");


        User byId = userService.getById(id);
        Random random = new Random();
        byId.setName("weix" + random.nextInt());
        userService.updateById(byId);
        int i = 1 / 0;

        return userService.getById(id);
    }

    /**
     * 添加user
     * @param u user实体
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public boolean addUser(User u) {
        System.out.printf(u.getEmail());
        return userService.save(u);
    }

    /**
     * 更新user
     * @param u user实体
     * @return
     */
    @RequestMapping(method=RequestMethod.PUT)
    public boolean updateUser(User u) {
        return userService.updateById(u);
    }

    /**
     * 按id删除user
     * @param id userId
     * @return
     */
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public String delUserById(@PathVariable("id") Integer id) {
        boolean b = userService.removeById(1);
        return String.valueOf(b);
    }

}
