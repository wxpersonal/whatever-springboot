package me.weix.whatever.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import me.weix.whatever.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weix
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     *
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
