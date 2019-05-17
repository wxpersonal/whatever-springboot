package me.weix.whatever.controller;

import io.shardingsphere.core.parsing.parser.context.OrderItem;
import me.weix.whatever.entity.Order;
import me.weix.whatever.entity.User;
import me.weix.whatever.service.IOrderItemService;
import me.weix.whatever.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : weixiang
 * create at:  2019-04-03
 * @description: sharding
 */
@RestController
@RequestMapping("sharding")
public class ShardingController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IOrderItemService orderItemService;

    @RequestMapping(value="/order/{id}", method= RequestMethod.GET)
    public Order getOrder(@PathVariable("id") String id) {
        return orderService.selectById(id);
    }

    @RequestMapping(value="/orderItem/{id}", method= RequestMethod.GET)
    public OrderItem getOrderItem(@PathVariable("id") String id) {
        return orderItemService.selectById(1);
    }

    @RequestMapping(value = "/order", method=RequestMethod.POST )
    public void putOrder(@RequestBody Order order) {
        orderService.insert(order);
    }

    @RequestMapping(value = "/orderItem", method=RequestMethod.POST)
    public void putOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.insert(orderItem);
    }
}
