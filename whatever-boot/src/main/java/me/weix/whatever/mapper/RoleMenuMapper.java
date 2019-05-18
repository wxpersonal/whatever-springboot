package me.weix.whatever.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.weix.whatever.entity.RoleMenu;

import java.util.List;

/**
 * @author weix
 * @since 2019-05-17
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    List<Integer> getMenuIdsByRoleId(List<Integer> roleId);
}
