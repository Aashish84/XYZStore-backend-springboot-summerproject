package com.asish.ecom.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asish.ecom.dao.OrderedItemDao;
import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.entities.Product;
import com.asish.ecom.helper.pojo.TopProduct;

@Service
public class AnalysisService {

	@Autowired
	private OrderedItemDao orderedItemDao;

	@Autowired
	private ProductDao productDao;

	List<TopProduct> topProducts;

	public List<TopProduct> topProductByOrder() {
		topProducts = new ArrayList<>();
		List<Object[]> findTopProduct = orderedItemDao.findTopProduct();
		for (Object[] tuple : findTopProduct) {
			// tuple is size 2
			// first product id
			// second count number of order
			Optional<Product> findById = productDao.findById(Integer.parseInt(tuple[0].toString()));
			int findProductOrderQuantity = orderedItemDao
					.findProductOrderQuantity(Integer.parseInt(tuple[0].toString()));

			TopProduct topProduct = new TopProduct();
			topProduct.setProductId(findById.get().getId());
			topProduct.setProductName(findById.get().getName());
			topProduct.setProductOrderCount(Integer.parseInt(tuple[1].toString()));
			topProduct.setProductQuantityCount(findProductOrderQuantity);

			topProducts.add(topProduct);
			topProduct = null;
		}
		return topProducts;
	}

	public List<TopProduct> topProductByQuantity() {
		topProducts = new ArrayList<>();
		List<Object[]> findTopProduct = orderedItemDao.findTopProduct();
		for (Object[] tuple : findTopProduct) {
			// tuple is size 2
			// first product id
			// second count number of order
			Optional<Product> findById = productDao.findById(Integer.parseInt(tuple[0].toString()));
			int findProductOrderQuantity = orderedItemDao
					.findProductOrderQuantity(Integer.parseInt(tuple[0].toString()));

			TopProduct topProduct = new TopProduct();
			topProduct.setProductId(findById.get().getId());
			topProduct.setProductName(findById.get().getName());
			topProduct.setProductOrderCount(Integer.parseInt(tuple[1].toString()));
			topProduct.setProductQuantityCount(findProductOrderQuantity);

			topProducts.add(topProduct);
			topProduct = null;
		}
		Collections.sort(topProducts);
		return topProducts;
	}
}
