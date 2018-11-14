package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author weix
 */
@Api(value="user")
@Path("user")
public class UserRest {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "根据id获取user")
    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiImplicitParam(name="id",value="用户id",dataType="integer", paramType = "path")
    public User getUserById(@ApiParam(value = "用户id") @PathParam("id") Integer id) {
        System.out.println("11111113333");
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
