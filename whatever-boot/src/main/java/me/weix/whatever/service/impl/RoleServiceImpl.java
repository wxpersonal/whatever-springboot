package me.weix.whatever.service.impl;

import me.weix.whatever.entity.Role;
import me.weix.whatever.mapper.RoleMapper;
import me.weix.whatever.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return baseMapper.getRolesByUserId(userId);
    }
}
