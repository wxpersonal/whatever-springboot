package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.shardingsphere.core.parsing.parser.context.OrderItem;
import me.weix.whatever.mapper.OrderItemMapper;
import me.weix.whatever.service.IOrderItemService;
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
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
