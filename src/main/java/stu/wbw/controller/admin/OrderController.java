package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.Order;
import stu.wbw.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * Order 控制器
 *
 */
@Controller
@RequestMapping("/admin")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/listOrder")
	public String list(Model model) {
		List<Order> orders = orderService.queryAllOrder();
		model.addAttribute("orders", orders);
		return "admin/listOrder";
	}

	@RequestMapping("/updateOrder")
	public String update(Order order) {
		orderService.updateOrder(order);
		return "redirect:listOrder";
	}

	@RequestMapping("/orderDelivery")
	public String delivery(Integer order_id) {
		Order order = orderService.queryOrderById(order_id);
		order.setDelivery_date(new Date());
		order.setStatus(OrderService.waitConfirm);
		orderService.updateOrder(order);
		return "redirect:listOrder";
	}
}
