package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IRedisTestService;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.Map;

@Api(value="redis")
@Path("redis")
public class RedisTestRest {

    @Autowired
    private IRedisTestService redisTestService;

    @Autowired
    private IUserService userService;


    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "取redis")
    @GET
    @Path(value = "{key}")
    public User get(@ApiParam(value = "redis key") @PathParam("key") String key) {
        return (User) redisTestService.get(key);
    }

    @ApiOperation(value = "存redis")
    @POST
    public void put(@FormParam(value = "111")  String id,
                    @FormParam(value = "222")  String id1) {
        User user = userService.selectById(1);
        redisTestService.put("user" + user.getId(), user);
    }
}
