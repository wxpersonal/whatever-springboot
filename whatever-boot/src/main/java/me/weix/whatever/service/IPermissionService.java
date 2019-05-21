package me.weix.whatever.service;

import me.weix.whatever.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author weix
 * @since 2019-05-17
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> getPermissionsByUserId(Integer userId);
}
