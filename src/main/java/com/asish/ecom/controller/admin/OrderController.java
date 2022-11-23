package com.asish.ecom.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asish.ecom.entities.Customer;
import com.asish.ecom.entities.OrderedItem;
import com.asish.ecom.service.CustomerService;
import com.asish.ecom.service.OrderedItemService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	@Autowired
	private OrderedItemService orderedItemService;

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String viewOrderCustomer(Model m) {
		List<Customer> allNewCustomer = customerService.getAllNewCustomer();
		m.addAttribute("allData", allNewCustomer);
		return "admin/order/view-post";
	}

	@RequestMapping(path = "/{customerId}", method = RequestMethod.GET)
	public String viewOrderById(Model m, @PathVariable("customerId") int customerId) {
		List<OrderedItem> orderedItemByCustomerId = orderedItemService.getOrderedItemByCustomerId(customerId);
		m.addAttribute("allData", orderedItemByCustomerId);
		return "admin/order/view-order";
	}
}
