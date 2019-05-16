package me.weix.whatever.controller;

import me.weix.whatever.entity.User;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    public User getUserById(@PathVariable("id") Integer id) {
        System.out.println("11111113333");
        return userService.selectById(id);
    }

    /**
     * 添加user
     * @param u user实体
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public boolean addUser(User u) {
        System.out.printf(u.getEmail());
        return userService.insert(u);
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
        boolean b = userService.deleteById(1);
        return String.valueOf(b);
    }
}
