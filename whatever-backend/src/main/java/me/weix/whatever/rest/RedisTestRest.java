package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IRedisTestService;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
    @Path(value = "{id}")
    public void put(@ApiParam(value = "user id") @PathParam("id") String id) {
        User user = userService.selectById(id);
        redisTestService.put("user" + user.getId(), user);
    }
}
