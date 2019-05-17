package me.weix.whatever.service.impl;

import me.weix.whatever.entity.Permission;
import me.weix.whatever.mapper.PermissionMapper;
import me.weix.whatever.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author weix
 * @since 2019-05-17
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
