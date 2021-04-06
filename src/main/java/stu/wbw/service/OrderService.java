package stu.wbw.service;

import stu.wbw.pojo.Order;
import stu.wbw.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    //订单状态
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    //增加一个订单
    int addOrder(Order order);
    //根据id删除一个订单
    int deleteOrderById(Integer id);
    //修改一个订单
    int updateOrder(Order order);
    //根据id查询一个订单
    Order queryOrderById(Integer id);
    //查询所有订单
    List<Order> queryAllOrder();
    //按照用户、订单状态查询订单
    List<Order> queryOrderByUserIdAndStatus(Integer user_id, String status);
    //返回user_id下的所有订单
    List<Order> queryAllOrderByUserId(Integer user_id);
    //增加一个订单，返回一个float类型数值用来表示订单的总价
    float add(Order order, List<OrderItem> orderItems);
}
