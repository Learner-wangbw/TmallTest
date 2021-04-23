package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.OrderItemMapper;
import stu.wbw.pojo.Order;
import stu.wbw.pojo.OrderItem;
import stu.wbw.pojo.Product;
import stu.wbw.service.OrderItemService;
import stu.wbw.service.ProductService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
    @Override
    public int addOrderItem(OrderItem orderItem) {
        return orderItemMapper.addOrderItem(orderItem);
    }

    @Override
    public int deleteOrderItemById(Integer id) {
        return orderItemMapper.deleteOrderItemById(id);
    }

    @Override
    public int updateOrderItem(OrderItem orderItem) {
        return orderItemMapper.updateOrderItem(orderItem);
    }

    @Override
    public OrderItem queryOrderItemById(Integer id) {
        OrderItem orderItem = orderItemMapper.queryOrderItemById(id);
        setProduct(orderItem);
        return orderItem;
    }

    @Override
    public List<OrderItem> queryAllOrderItemByOrderId(Integer order_id) {
        List<OrderItem> result = orderItemMapper.queryAllOrderItemByOrderId(order_id);
        setProduct(result);
        return result;

    }

    @Override
    public List<OrderItem> queryAllOrderItemByUserId(Integer user_id) {
        List<OrderItem> result = orderItemMapper.queryAllOrderItemByUserId(user_id);
        setProduct(result);
        return result;
    }

    //注意:该查询是查询该user_id下并且order_id为空的数据
    //因为购物车中的产品无订单id
    @Override
    public List<OrderItem> queryAllOrderItemByUserIdForCart(Integer user_id) {
        List<OrderItem> orderItems = orderItemMapper.queryAllOrderItemByUserIdForCart(user_id);
        setProduct(orderItems);
        return orderItems;
    }

    @Override
    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    @Override
    public void fill(Order o) {
        List<OrderItem> orderItems = orderItemMapper.queryAllOrderItemByOrderId(o.getId());
        setProduct(orderItems);
        //订单总价
        float total = 0;
        //订单中产品数量
        int totalNumber = 0;
        for (OrderItem oi : orderItems) {
            total += oi.getNumber() * oi.getProduct().getPrice();
            totalNumber += oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(orderItems);
    }

    private void setProduct(OrderItem oi){
        Product product = productService.queryProductById(oi.getProduct_id());
        oi.setProduct(product);
    }

    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi : ois) {
            setProduct(oi);
        }
    }
}
