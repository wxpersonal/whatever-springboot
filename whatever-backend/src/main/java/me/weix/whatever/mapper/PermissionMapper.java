
package me.weix.whatever.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import me.weix.whatever.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weix
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 在下面添加自定义方法
     */
    List<Permission> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}