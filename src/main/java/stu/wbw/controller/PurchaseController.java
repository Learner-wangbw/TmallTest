package stu.wbw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import stu.wbw.pojo.Order;
import stu.wbw.pojo.OrderItem;
import stu.wbw.pojo.Product;
import stu.wbw.pojo.User;
import stu.wbw.service.OrderItemService;
import stu.wbw.service.OrderService;
import stu.wbw.service.ProductService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物流程控制器
 */
@Controller
public class PurchaseController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderService orderService;


    /**
     * 立即购买（即新增OrderItem项）需要考虑以下两种情况：
     * 1.如果这个产品已经存在于购物车中，那么只需要相应的调整数量就可以了
     * 2.如果不存在对应的OrderItem项，那么就新增一个订单项（OrderItem）
     * - 前提条件：已经登录
     */
    @RequestMapping("/buyone")
    public String buyone(Integer product_id, Integer number, HttpSession session) {
        Product product = productService.queryProductById(product_id);
        int orderItemId = 0;

        User user = (User) session.getAttribute("user");
        boolean found = false;
        List<OrderItem> orderItems = orderItemService.queryAllOrderItemByUserId(user.getId());
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct_id().intValue() == product.getId().intValue()) {
                orderItem.setNumber(orderItem.getNumber() + number);
                orderItemService.updateOrderItem(orderItem);
                orderItemId = orderItem.getId();
                break;
            }
        }

        if (!found) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUser_id(user.getId());
            orderItem.setNumber(number);
            orderItem.setProduct_id(product_id);
            orderItemService.addOrderItem(orderItem);
            //System.out.println(orderItem.toString());
            orderItemId = orderItem.getId();
        }

        return "redirect:buy?orderItemId=" + orderItemId;
    }

    @RequestMapping("/buy")
    public String buy(Model model, String[] orderItemId, HttpSession session) {
        List<OrderItem> orderItems = new ArrayList<>();
        //产品总价格
        float total = 0;

        for (String strId : orderItemId) {
            int id = Integer.parseInt(strId);
            OrderItem oi = orderItemService.queryOrderItemById(id);
            total += oi.getProduct().getPrice() * oi.getNumber();
            orderItems.add(oi);
        }

        session.setAttribute("orderItems", orderItems);
        model.addAttribute("total", total);
        return "buyPage";
    }

    //创建订单
    @RequestMapping("/createOrder")
    public String createOrder(Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        order.setOrder_code(orderCode);
        order.setCreate_date(new Date());
        order.setUser_id(user.getId());
        order.setStatus(OrderService.waitPay);
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        float total = orderService.add(order, orderItems);
        return "redirect:payPage?order_id=" + order.getId() + "&total=" + total;
    }

    //支付页面
    @RequestMapping("/payed")
    public String payed(int order_id, Model model) {
        Order order = orderService.queryOrderById(order_id);
        order.setStatus(OrderService.waitDelivery);
        order.setPay_date(new Date());
        orderService.updateOrder(order);
        model.addAttribute("o", order);
        return "payed";
    }

    /**
     * 加入购物车方法，跟buyone()方法有些类似，但返回不同
     * 仍然需要新增订单项OrderItem，考虑两个情况：
     * 1.如果这个产品已经存在于购物车中，那么只需要相应的调整数量就可以了
     * 2.如果不存在对应的OrderItem项，那么就新增一个订单项（OrderItem）
     * - 前提条件：已经登录
     */
    @RequestMapping("/addCart")
    @ResponseBody
    public String addCart(int product_id, int num, HttpSession session) {
        Product p = productService.queryProductById(product_id);
        User user = (User) session.getAttribute("user");
        boolean found = false;

        List<OrderItem> ois = orderItemService.queryAllOrderItemByUserIdForCart(user.getId());
        for (OrderItem oi : ois) {
            if (oi.getProduct().getId().intValue() == p.getId().intValue()) {
                oi.setNumber(oi.getNumber() + num);
                orderItemService.updateOrderItem(oi);
                found = true;
                break;
            }
        }

        if (!found) {
            OrderItem oi = new OrderItem();
            oi.setUser_id(user.getId());
            oi.setNumber(num);
            oi.setProduct_id(product_id);
            orderItemService.addOrderItem(oi);
        }

        return "success";
    }

    /**
     * 查看购物车方法：
     * 1.首先通过session获取到当前的用户
     * 2.获取这个用户关联的订单项的集合
     */
    @RequestMapping("/cart")
    public String cart(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.queryAllOrderItemByUserIdForCart(user.getId());
        model.addAttribute("orderItems", orderItems);
        return "cart";
    }


    //修改订单货物
    @RequestMapping("/changeOrderItem")
    @ResponseBody
    public String changeOrderItem(HttpSession session, int product_id, int number) {
        User user = (User) session.getAttribute("user");
        if (null == user)
            return "fail";

        List<OrderItem> ois = orderItemService.queryAllOrderItemByUserId(user.getId());
        for (OrderItem oi : ois) {
            if (oi.getProduct().getId() == product_id) {
                oi.setNumber(number);
                orderItemService.updateOrderItem(oi);
                break;
            }
        }
        return "success";
    }
    //删除订单货物
    @RequestMapping("/deleteOrderItem")
    @ResponseBody
    public String deleteOrderItem(HttpSession session, Integer orderItemId) {
        User user = (User) session.getAttribute("user");
        if (null == user)
            return "fail";
        orderItemService.deleteOrderItemById(orderItemId);
        return "success";
    }

    //查看全部订单，排除已删除的订单
    @RequestMapping("/bought")
    public String bought(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.queryOrderByUserIdAndStatus(user.getId(), OrderService.delete);
        orderItemService.fill(orders);
		/*Product product = null;
		for (Order order : orders) {
			List<OrderItem> orderItems = order.getOrderItems();
			for (OrderItem orderItem : orderItems) {
				product = orderItem.getProduct();
			}
		}
		model.addAttribute("product",product);*/
        model.addAttribute("orders", orders);

        return "bought";
    }

    //确认支付
    @RequestMapping("/confirmPay")
    public String confirmPay(Model model, Integer order_id) {
        Order order = orderService.queryOrderById(order_id);
        orderItemService.fill(order);
        model.addAttribute("order", order);
        return "confirmPay";
    }

    //订单确认
    @RequestMapping("/orderConfirmed")
    public String orderConfirmed(Integer order_id) {
        Order o = orderService.queryOrderById(order_id);
        o.setStatus(OrderService.waitReview);
        o.setConfirm_date(new Date());
        orderService.updateOrder(o);
        return "orderConfirmedPage";
    }

    //删除订单
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(Integer order_id) {
        Order o = orderService.queryOrderById(order_id);
        o.setStatus(OrderService.delete);
        orderService.updateOrder(o);
        return "success";
    }
}
