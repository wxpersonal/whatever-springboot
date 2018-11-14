package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.weix.whatever.entity.Permission;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author weix
 */
@Api(value="PermissionRest")
@Path("permission")
public class PermissionRest {

    @ApiOperation(value = "根据id获取permission")
    @GET
    @Path(value = "{id}")
    public Permission getPermissionById(@PathParam("id") Integer id) {
        return new Permission();
    }

}
