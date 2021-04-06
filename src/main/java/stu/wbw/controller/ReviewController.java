package stu.wbw.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stu.wbw.pojo.*;
import stu.wbw.service.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 评价控制器
 */
@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	OrderItemService orderItemService;

	@Autowired
	OrderService orderService;


	//显示评价
	@RequestMapping("/review")
	public String review(Model model, Integer order_id) {
		Order order = orderService.queryOrderById(order_id);
		orderItemService.fill(order);
		//Product product = order.getOrderItems().get(0).getProduct();
		Product product = orderItemService.queryAllOrderItemByOrderId(order_id).get(0).getProduct();
		List<Review> reviews = reviewService.queryReviewByProductId(product.getId());

		model.addAttribute("product", product);
		model.addAttribute("order", order);
		model.addAttribute("reviews", reviews);
		return "reviewPage";
	}

	//添加评价
	@RequestMapping("/doreview")
	public String doreview(HttpSession session,
                           @RequestParam("order_id") Integer order_id,
                           @RequestParam("product_id") Integer product_id,
                           String content) {

		Order order = orderService.queryOrderById(order_id);
		order.setStatus(OrderService.finish);
		orderService.updateOrder(order);

		User user = (User) session.getAttribute("user");
		Review review = new Review();
		review.setContent(content);
		review.setProduct_id(product_id);
		review.setCreateDate(new Date());
		review.setUser_id(user.getId());
		reviewService.addReview(review);

		return "redirect:review?order_id=" + order_id + "&showonly=true";
	}

}
