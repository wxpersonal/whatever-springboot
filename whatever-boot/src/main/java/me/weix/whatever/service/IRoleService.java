package me.weix.whatever.service;

import me.weix.whatever.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author weix
 * @since 2019-05-17
 */
public interface IRoleService extends IService<Role> {

    /**
     * 取用户role
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(Integer userId);
}
