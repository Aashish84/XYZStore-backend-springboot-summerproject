package com.asish.ecom.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asish.ecom.entities.OrderedItem;
import com.asish.ecom.service.OrderedItemService;

@RestController
@RequestMapping("/api/ordereditem")
public class RestOrderedItemController {
	@Autowired
	private OrderedItemService orderedItemService;

	@GetMapping
	public List<OrderedItem> getAll() {
		return orderedItemService.getAllOrderedItem();
	}

	@PostMapping
	public OrderedItem post(@RequestBody OrderedItem oi) throws Exception {
		return orderedItemService.addOrderedItem(oi);
	}

	@PostMapping("/multiple")
	public boolean post(@RequestBody List<OrderedItem> listoi) throws Exception {
		return orderedItemService.addAllOrderedItem(listoi);
	}
}
