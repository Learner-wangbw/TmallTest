package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.ReferalLink;
import stu.wbw.service.ReferalLinkService;

import java.util.List;

/**
 * ReferalLink 控制器
 */
@Controller
@RequestMapping("/admin")
public class ReferalLinkController {

	@Autowired
	ReferalLinkService referalLinkService;

	@RequestMapping("/listLink")
	public String list(Model model) {
		List<ReferalLink> links = referalLinkService.queryAllReferalLink();
		model.addAttribute("links", links);
		return "admin/listLink";
	}


	/*@RequestMapping("/editLink")
	public String edit(Model model, Integer id) {
		ReferalLink link = referalLinkService.get(id);
		model.addAttribute("link", link);
		return "admin/editLink";
	}*/

	/*@RequestMapping("/toUpdateLink")
	public String toUpdate(){
		return "redirect:editLink";
	}*/

	@RequestMapping("/updateLink")
	public String update(ReferalLink link) {
		referalLinkService.updateReferalLink(link);
		return "redirect:listLink";
	}
}
