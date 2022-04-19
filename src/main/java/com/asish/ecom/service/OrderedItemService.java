package com.asish.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asish.ecom.dao.CustomerDao;
import com.asish.ecom.dao.OrderedItemDao;
import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.entities.Customer;
import com.asish.ecom.entities.OrderedItem;
import com.asish.ecom.entities.Product;

@Service
public class OrderedItemService {
	@Autowired
	private OrderedItemDao orderedItemDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CustomerDao customerDao;

	public List<OrderedItem> getAllOrderedItem() {
		return (List<OrderedItem>) orderedItemDao.findAll();
	}

	public List<OrderedItem> getOrderedItemByCustomerId(int id) {
		List<OrderedItem> findByCustomer = orderedItemDao.findByCustomerId(id);
		return findByCustomer;
	}

	public OrderedItem addOrderedItem(OrderedItem oi) throws Exception {
		Optional<Product> findById = productDao.findById(oi.getProduct().getId());
		if (findById.isPresent()) {
			Optional<Customer> findById2 = customerDao.findById(oi.getCustomer().getId());
			if (findById2.isPresent()) {
				OrderedItem save = orderedItemDao.save(oi);
				save.setProduct(findById.get());
				return save;
			} else {
				throw new Exception("customer not found to add");
			}
		} else {
			throw new Exception("product not found to add");
		}
	}

	public boolean addAllOrderedItem(List<OrderedItem> listoi) {
		if (((List<OrderedItem>) orderedItemDao.saveAll(listoi)).size() > 0) {
			return true;
		}
		return false;
	}
}
