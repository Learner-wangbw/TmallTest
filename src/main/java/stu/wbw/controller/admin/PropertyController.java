package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.Category;
import stu.wbw.pojo.Property;
import stu.wbw.service.CategoryService;
import stu.wbw.service.PropertyService;

import java.util.List;

/**
 * Property 控制器
 */
@Controller
@RequestMapping("/admin")
public class PropertyController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	PropertyService propertyService;

	@RequestMapping("/listProperty")
	public String list(Model model, Integer category_id) {
		List<Property> properties = propertyService.queryAllPropertyByCategoryId(category_id);
		model.addAttribute("properties", properties);
		Category category = categoryService.queryCategoryById(category_id);
		model.addAttribute("category", category);
		return "admin/listProperty";
	}

	@RequestMapping("/addProperty")
	public String add(Property property) {
		propertyService.addProperty(property);
		return "redirect:listProperty?category_id=" + property.getCategory_id();
	}

	@RequestMapping("/deleteProperty")
	public String delete(Integer id) {
		int category_id = propertyService.queryProperty(id).getCategory_id();
		propertyService.deleteProperty(id);
		return "redirect:listProperty?category_id=" + category_id;
	}

	@RequestMapping("/editProperty")
	public String edit(Integer id, Model model) {
		Property property = propertyService.queryProperty(id);
		model.addAttribute("property", property);
		Category category = categoryService.queryCategoryById(property.getCategory_id());
		model.addAttribute("category", category);
		return "admin/editProperty";
	}

	@RequestMapping("/updateProperty")
	public String update(Property property) {
		propertyService.updateProperty(property);
		return "redirect:listProperty?category_id=" + property.getCategory_id();
	}
}
