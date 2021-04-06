package stu.wbw.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.*;
import stu.wbw.service.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    ReferalLinkService referalLinkService;

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    ReviewService reviewService;


    /**
     * 首页访问方法，给首页的JSP页面添加以下数据：
     */
    @RequestMapping("/home")
    public String home(Model model){
        List<Category> categories = categoryService.queryAllCategory();
        productService.fill(categories);
        productService.fillByRow(categories);
        List<ReferalLink> links = referalLinkService.queryAllReferalLink();

        model.addAttribute("categories",categories);
        model.addAttribute("links",links);
        return "index";
    }

    //展示产品
    @RequestMapping("/showProduct")
    public String showProduct(Model model,Integer product_id){
        Product product = productService.queryProductById(product_id);
        productService.setReviewCount(product);
        model.addAttribute("product",product);

        List<PropertyValue> propertyValues = propertyValueService.queryByProductId(product_id);
        model.addAttribute("propertyValues",propertyValues);

        List<Review> reviews = reviewService.queryReviewByProductId(product_id);
        model.addAttribute("reviews",reviews);
        return "product";
    }

    //根据关键字查询产品
    @RequestMapping("/searchProduct")
    public String searchProduct(Model model,String keyword){
        PageHelper.offsetPage(0,20);
        List<Product> products = productService.search(keyword);
        for (Product product : products) {
            product.setReviewCount(reviewService.getReviewCount(product.getId()));
        }
        model.addAttribute("products",products);
        return "searchResult";
    }

    //为产品排序
    @RequestMapping("/sortProduct")
    public String sortProduct(Model model,String sort,String keyword){
        List<Product> products = productService.search(keyword);
        for (Product product : products) {
            product.setReviewCount(reviewService.getReviewCount(product.getId()));
        }
        if (null != sort) {
            switch (sort) {
                case "all":
                    Collections.sort(products, Comparator.comparing(Product::getSaleXReviewCount));
                    break;
                case "reviewCount":
                    Collections.sort(products, Comparator.comparing(Product::getReviewCount));
                    break;
                case "date":
//					Collections.sort(products, comparing(Product::get));
                    break;
                case "sale":
                    Collections.sort(products, Comparator.comparing(Product::getSale));
                    break;
                case "price":
                    Collections.sort(products, Comparator.comparing(Product::getPrice));
                    break;
            }
        }
        model.addAttribute("products", products);

        return "searchResult";
    }
}
