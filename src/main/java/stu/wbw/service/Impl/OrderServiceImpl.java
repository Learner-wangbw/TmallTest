package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import stu.wbw.mapper.OrderItemMapper;
import stu.wbw.mapper.OrderMapper;
import stu.wbw.pojo.Order;
import stu.wbw.pojo.OrderItem;
import stu.wbw.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrderById(Integer id) {
        return orderMapper.deleteOrderById(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public Order queryOrderById(Integer id) {
        return orderMapper.queryOrderById(id);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderMapper.queryAllOrder();
    }

    @Override
    public List<Order> queryOrderByUserIdAndStatus(Integer user_id, String status) {
        return orderMapper.queryOrderByUserIdAndStatus(user_id,status);
    }

    @Override
    public List<Order> queryAllOrderByUserId(Integer user_id) {
        return orderMapper.queryAllOrderByUserId(user_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public float add(Order order, List<OrderItem> orderItems) {
        float total = 0;
        addOrder(order);
        // 用来模拟当增加订单后出现异常，观察事务管理是否预期发生
        if (false) throw new RuntimeException();

        for (OrderItem oi : orderItems) {
            oi.setOrder_id(order.getId());
            orderItemMapper.updateOrderItem(oi);
            total+=oi.getProduct().getPrice()*oi.getNumber();
        }
        return total;
    }
}
