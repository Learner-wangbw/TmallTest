package stu.wbw.mapper;

import org.apache.ibatis.annotations.Param;
import stu.wbw.pojo.Order;

import java.util.List;

public interface OrderMapper {
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
    List<Order> queryOrderByUserIdAndStatus(@Param("user_id") Integer user_id, @Param("status") String status);
    //返回user_id下的所有订单
    List<Order> queryAllOrderByUserId(Integer user_id);
}
