package me.weix.whatever.mapper;

import me.weix.whatever.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 取用户role
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(Integer userId);
}
