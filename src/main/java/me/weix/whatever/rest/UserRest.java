package me.weix.whatever.rest;

import me.weix.whatever.pojo.User;
import me.weix.whatever.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(description = "user相关操作")
@Path("user")
public class UserRest {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "根据id获取user")
    @GET
    @Path(value = "id/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "添加user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "addUser")
    public Integer addUser(User u) {

        System.out.printf(u.getEmail());
        return 111;//userService.insert(u);
    }

}
