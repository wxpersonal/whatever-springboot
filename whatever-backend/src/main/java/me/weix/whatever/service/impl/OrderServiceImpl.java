package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import me.weix.whatever.entity.Order;
import me.weix.whatever.mapper.OrderMapper;
import me.weix.whatever.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weix
 * @since 2019-04-03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
