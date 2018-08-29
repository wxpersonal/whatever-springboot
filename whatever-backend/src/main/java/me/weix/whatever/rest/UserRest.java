package me.weix.whatever.rest;

import io.swagger.annotations.*;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

@Api(value="user")
@Path("user")
public class UserRest {

    @Autowired
    private IUserService userService;


    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据id获取user")
    @GET
    @Path(value = "{id}")
    @ApiImplicitParam(name="id",value="用户id",dataType="integer", paramType = "path")
    public User getUserById(@ApiParam(value = "用户id") @PathParam("id") Integer id) {
        return userService.selectById(id);
    }

    @ApiOperation(value = "添加user")
    @POST
    public boolean addUser(@ApiParam(value = "用户实体") User u) {
        System.out.printf(u.getEmail());
        return userService.insert(u);
    }

    @ApiOperation(value = "更新user")
    @PUT
    public boolean updateUser(@ApiParam(value = "用户实体") User u) {
        return userService.updateById(u);
    }

    @ApiOperation(value = "按id删除user")
    @DELETE
    @Path(value = "{id}")
    public String delUserById(@ApiParam(value = "用户id") @PathParam("id") Integer id) {
        boolean b = userService.deleteById(1);
        return String.valueOf(b);
    }
}
