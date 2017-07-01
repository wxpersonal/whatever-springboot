package me.weix.whatever.rest;

import me.weix.whatever.pojo.Permission;
import me.weix.whatever.pojo.UserDTO;
import me.weix.whatever.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Api(description = "permissionController")
@Path("permission")
public class PermissionRest {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "根据id获取permission")
    @GET
    @Path(value = "id/{id}")
    public Permission getPermissionById(@PathVariable Integer id, HttpServletRequest request) {
        return new Permission();
    }

}
