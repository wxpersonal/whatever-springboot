package me.weix.whatever.controller;

import me.weix.whatever.entity.Permission;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author weix
 */
@RestController
@RequestMapping("user")
public class PermissionController {

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Permission getPermissionById(@PathVariable("id") Integer id) {
        return new Permission();
    }

}
