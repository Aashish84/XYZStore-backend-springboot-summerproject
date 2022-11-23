package com.asish.ecom.controller.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asish.ecom.dao.OrderedItemDao;
import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.helper.pojo.TopBrand;
import com.asish.ecom.service.AnalysisService;

@Controller
@RequestMapping("/admin/analysis")
public class AnalysisController {

	@Autowired
	private AnalysisService analysisService;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderedItemDao orderedItemDao;

	@RequestMapping(path = "/topproductorder", method = RequestMethod.GET)
	public String getProductByOrderNumber(Model m) {
		m.addAttribute("topProductOrder", analysisService.topProductByOrder());
		return "admin/index";
	}

	@RequestMapping(path = "/topproductquantity", method = RequestMethod.GET)
	public String getProductByQuantityNumber(Model m) {
		m.addAttribute("topProductQuantity", analysisService.topProductByQuantity());
		return "admin/index";
	}

	@RequestMapping(path = "/topbrandproduct", method = RequestMethod.GET)
	public String getTopProductByBrand(Model m) {
		List<TopBrand> tb = new ArrayList<>();

		List<String> findDistintBrand = productDao.findDistintBrand();
		for (String tmp : findDistintBrand) {
			TopBrand ob = new TopBrand();
			ob.setBrandName(tmp);
			tb.add(ob);
			ob = null;
		}

		for (int i = 0; i < tb.size(); i++) {
			TopBrand tmp = tb.get(i);
			List<Integer> findProductIdFromBrand = productDao.findProductIdFromBrand(tmp.getBrandName());
			int tmpQty = 0;
			int tmpCount = 0;
			for (int pid : findProductIdFromBrand) {
				List<Object[]> findProductOrderQuantityForBrand = orderedItemDao.findProductOrderQuantityForBrand(pid);
				if (findProductOrderQuantityForBrand.get(0)[0] != null) {
					tmpQty += Integer.parseInt(findProductOrderQuantityForBrand.get(0)[0].toString());
					tmpCount += Integer.parseInt(findProductOrderQuantityForBrand.get(0)[1].toString());
				}
			}
			TopBrand ob = new TopBrand();
			ob.setBrandName(tmp.getBrandName());
			ob.setOrderQty(tmpQty);
			ob.setOrderCount(tmpCount);
			tb.set(i, ob);
		}
		Collections.sort(tb);
		m.addAttribute("topProductQuantityBrand", tb);

		return "admin/index";
	}

}
