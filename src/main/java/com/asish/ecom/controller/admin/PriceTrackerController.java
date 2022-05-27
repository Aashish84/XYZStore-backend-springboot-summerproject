package com.asish.ecom.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asish.ecom.dao.PriceTrackerDao;
import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.entities.PriceTracker;
import com.asish.ecom.entities.Product;

@Controller
@RequestMapping("/admin/pricetracker")
public class PriceTrackerController {

	@Autowired
	private PriceTrackerDao priceTrackerDao;

	@Autowired
	private ProductDao productDao;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model m) {
		List<Object[]> findOnlyName = productDao.findOnlyName();
		List<Product> lProducts = new ArrayList<>();
		for (Object[] tmp : findOnlyName) {
			Product product = new Product();
			product.setId(Integer.parseInt(tmp[0].toString()));
			product.setName(tmp[1].toString());
			lProducts.add(product);
		}
		m.addAttribute("allData", lProducts);
		return "/admin/priceTracker/view-post";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String getHighAndLowPrice(@PathVariable("id") int id, Model m) {
		List<PriceTracker> findByProduct = priceTrackerDao.findByProduct(id);
		PriceTracker great = null;
		PriceTracker low = null;
		for (int i = 0; i < findByProduct.size(); i++) {
			if (great == null) {
				great = findByProduct.get(i);
			}
			if (low == null) {
				low = findByProduct.get(i);
			}
			if (great.getPrice() < findByProduct.get(i).getPrice()) {
				great = findByProduct.get(i);
			}
			if (low.getPrice() > findByProduct.get(i).getPrice()) {
				low = findByProduct.get(i);
			}
		}
		m.addAttribute("greatPrice", great);
		m.addAttribute("lowPrice", low);
		m.addAttribute("allData", findByProduct);
		return "/admin/priceTracker/view-single";
	}
}
