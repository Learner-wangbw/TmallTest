package stu.wbw.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import stu.wbw.pojo.OrderItem;
import stu.wbw.pojo.User;
import stu.wbw.service.CategoryService;
import stu.wbw.service.OrderItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OtherInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;

    /*在业务处理器处理请求之前被调用
     * - 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion()方法，再退出拦截器链
     * - 如果返回true
     * 执行下一个拦截器，知道素有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链，
     * 从最后一个拦截器往回执行所有的postHandel()方法
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()方法*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //这里是获取购物车中一共有多少数量
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int cartTotalItemNumber = 0;
        if (null != user){
            List<OrderItem> ois = orderItemService.queryAllOrderItemByUserId(user.getId());
            for (OrderItem oi : ois) {
                cartTotalItemNumber += oi.getNumber();
            }
        }
        //用于显示购物车存在多少件
        session.setAttribute("cartTotalItemNumber",cartTotalItemNumber);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
