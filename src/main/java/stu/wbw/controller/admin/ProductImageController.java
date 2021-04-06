package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import stu.wbw.pojo.Product;
import stu.wbw.pojo.ProductImage;
import stu.wbw.service.ProductImageService;
import stu.wbw.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * ProductImage 的控制器
 */
@Controller
@RequestMapping("/admin")
public class ProductImageController {

	@Autowired
	ProductImageService productImageService;

	@Autowired
	ProductService productService;

	@RequestMapping("/editProductImage")
	public String edit(Model model, Integer product_id) {
		List<ProductImage> productImages = productImageService.queryAllProductImageByProductId(product_id);
		model.addAttribute("productImages", productImages);
		Product product = productService.queryProductById(product_id);
		model.addAttribute("product", product);
		return "admin/editProductImage";
	}

	@RequestMapping(value = "/updateProductImage", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
						 Integer product_id,
						 Integer id,
						 @RequestParam("picture") MultipartFile picture) {

		// 上传文件到指定位置
		String filePath = request.getSession().getServletContext()
				.getRealPath("img/product/" + product_id);
		// 因为 id 是自增长键，所以需要 % 5 来作为文件名
		String fileName = (id % 5 == 0 ? 5 : id % 5) + ".jpg";
		File uploadPicture = new File(filePath, fileName);
		if (!uploadPicture.exists()) {
			uploadPicture.mkdirs();
		}
		// 保存
		try {
			picture.transferTo(uploadPicture);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:editProductImage?product_id=" + product_id;
	}

	@RequestMapping("/deleteProductImage")
	public String delete(Integer id, Integer product_id, HttpServletRequest request) {
		// 不删除表中的数据（在 ProductController 中统一删除），删除对应文件
		String filePath = request.getSession().getServletContext()
				.getRealPath("img/product/" + product_id);
		String fileName = id + ".jpg";
		new File(filePath, fileName).delete();
		productImageService.deleteProductImageById(id);

		return "redirect:editProductImage?product_id=" + product_id;
	}
}
