package me.weix.whatever.mapper;

import me.weix.whatever.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.weix.whatever.entity.Role;

import java.util.List;

/**
 * @author weix
 * @since 2019-05-17
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 取用户Permission
     * @param userId
     * @return
     */
    List<Permission> getPermissionsByUserId(Integer userId);
}
