package me.weix.whatever.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IRedisTestService;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author weix
 */
@RestController
@RequestMapping("redis")
public class RedisTestRest {

    @Autowired
    private IRedisTestService redisTestService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value="{key}", method=RequestMethod.GET)
    public User get(@PathVariable("key") String key) {
        return (User) redisTestService.get(key);
    }

    @RequestMapping(method=RequestMethod.POST)
    public void put(String id, String id1) {
        User user = userService.getById(1);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        redisTestService.put("user" + user.getId(), user);
    }
}
