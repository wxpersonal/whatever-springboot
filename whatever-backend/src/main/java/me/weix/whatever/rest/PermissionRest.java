package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.weix.whatever.entity.Permission;
import me.weix.whatever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Api(value="PermissionRest")
@Path("permission")
public class PermissionRest {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "根据id获取permission")
    @GET
    @Path(value = "{id}")
    public Permission getPermissionById(@PathParam("id") Integer id) {
        return new Permission();
    }

}
