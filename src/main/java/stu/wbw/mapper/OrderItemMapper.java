package stu.wbw.mapper;

import stu.wbw.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    //增加一个订单货物
    int addOrderItem(OrderItem orderItem);
    //根据ID删除一个订单货物
    int deleteOrderItemById(Integer id);
    //修改一个订单货物
    int updateOrderItem(OrderItem orderItem);
    //根据id查询一个订单货物
    OrderItem queryOrderItemById(Integer id);
    //通过订单id查询该订单下所有的Item
    List<OrderItem> queryAllOrderItemByOrderId(Integer order_id);
    //通过user_id查询该用户对应的所有订单项
    List<OrderItem> queryAllOrderItemByUserId(Integer user_id);
    //返回当前user_id下的购物车订单列表
    List<OrderItem> queryAllOrderItemByUserIdForCart(Integer user_id);

}
