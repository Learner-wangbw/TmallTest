package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.Product;
import stu.wbw.pojo.Property;
import stu.wbw.pojo.PropertyValue;
import stu.wbw.service.ProductService;
import stu.wbw.service.PropertyService;
import stu.wbw.service.PropertyValueService;

import java.util.List;

/**
 * PropertyValue 控制类
 */
@Controller
@RequestMapping("/admin")
public class PropertyValueController {

	@Autowired
	PropertyValueService propertyValueService;

	@Autowired
	ProductService productService;

	@Autowired
	PropertyService propertyService;

	@RequestMapping("/listPropertyValue")
	public String list(Model model, Integer product_id, Integer category_id) {
		List<PropertyValue> propertyValues = propertyValueService.queryByProductId(product_id);
		model.addAttribute("propertyValues", propertyValues);
		Product product = productService.queryProductById(product_id);
		model.addAttribute("product", product);
		List<Property> properties = propertyService.queryAllPropertyByCategoryId(category_id);
		model.addAttribute("properties", properties);
		return "admin/listPropertyValue";
	}

	@RequestMapping("/addPropertyValue")
	public String add(PropertyValue propertyValue) {
		int product_id = propertyValue.getProduct_id();
		int category_id = productService.queryProductById(product_id).getCategory_id();
		propertyValueService.addPropertyValue(propertyValue);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}

	@RequestMapping("/deletePropertyValue")
	public String delete(Integer id) {
		int product_id = propertyValueService.queryPropertyValueById(id).getProduct_id();
		int category_id = productService.queryProductById(product_id).getCategory_id();
		propertyValueService.deletePropertyValueById(id);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}

	@RequestMapping("/editPropertyValue")
	public String edit(Integer id, Model model) {
		PropertyValue propertyValue = propertyValueService.queryPropertyValueById(id);
		model.addAttribute("propertyValue", propertyValue);
		Product product = productService.queryProductById(propertyValue.getProduct_id());
		model.addAttribute("product", product);
		return "admin/editPropertyValue";
	}

	@RequestMapping("/updatePropertyValue")
	public String update(PropertyValue propertyValue) {
		int product_id = propertyValue.getProduct_id();
		int category_id = productService.queryProductById(product_id).getCategory_id();
		propertyValueService.updatePropertyValue(propertyValue);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}
}
