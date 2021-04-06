package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.Category;
import stu.wbw.service.CategoryService;

import java.util.List;

/**
 * Category 物品类别的控制类
 *
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/listCategory")
	public String list(Model model) {
		List<Category> categories = categoryService.queryAllCategory();
		model.addAttribute("categories", categories);
		return "admin/listCategory";
	}

	@RequestMapping("/editCategory")
	public String edit(Category category, Model model) {
		model.addAttribute("category", category);
		return "admin/editCategory";
	}

	@RequestMapping("/updateCategory")
	public String update(Category category) {
		categoryService.updateCategory(category);
		return "redirect:listCategory";
	}
}
