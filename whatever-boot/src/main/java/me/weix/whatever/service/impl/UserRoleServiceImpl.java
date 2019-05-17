package me.weix.whatever.service.impl;

import me.weix.whatever.entity.UserRole;
import me.weix.whatever.mapper.UserRoleMapper;
import me.weix.whatever.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
