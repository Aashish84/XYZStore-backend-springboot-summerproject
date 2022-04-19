package com.asish.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asish.ecom.dao.CategoryDao;
import com.asish.ecom.dao.ProductDao;
import com.asish.ecom.entities.Category;
import com.asish.ecom.entities.Product;
import com.asish.ecom.helper.ProductImageUpload;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductImageUpload productImageUpload;

	// get
	public List<Product> getAllProduct() throws Exception {
		List<Product> products = (List<Product>) productDao.findAll();
		if (products.size() == 0) {
			throw new Exception("zero product found");
		}
		return products;
	}

	public List<Product> getProductWithLimit() {
		List<Product> products = (List<Product>) productDao.findMultipleWithLimit();
		return products;
	}

	public Product getProduct(int id) throws Exception {
		Optional<Product> findById = productDao.findById(id);
		if (!findById.isPresent()) {
			throw new Exception("desired product not found");
		}
		return findById.get();
	}

	public List<Product> getProductByName(String searchTxt) {
		if (searchTxt != null && searchTxt.length() > 0) {
			return productDao.findByNameContaining(searchTxt);
		}
		return null;
	}

	public List<Product> getProductByCategory(int id) throws Exception {
		Optional<Category> findById = categoryDao.findById(id);
		if (findById.isPresent()) {
			List<Product> findByCategory = productDao.findByCategory(findById.get());
			return findByCategory;
		}
		throw new Exception("enter valid category id");
	}

	// add
	public Product addProduct(Product p) throws Exception {
		int categoryId = p.getCategory().getId();
		Optional<Category> findById = categoryDao.findById(categoryId);
		if (!findById.isPresent()) {
			throw new Exception("category doesnot exist to put the item ");
		}
		return productDao.save(p);
	}

	public Product addProduct(Product p, int categoryId) throws Exception {
		Optional<Category> findById = categoryDao.findById(categoryId);
		if (!findById.isPresent()) {
			throw new Exception("category doesnot exist to put the item ");
		}
		p.setCategory(findById.get());
		return productDao.save(p);
	}

	public Product addProduct(Product p, int categoryId, MultipartFile file) throws Exception {
		Optional<Category> findById = categoryDao.findById(categoryId);

		Optional<Product> findByFirstImageName = productDao.findByFirstImageName(file.getOriginalFilename());
		if (findByFirstImageName.isPresent()) {
			throw new Exception("image name already exist change it");
		}

		if (!findById.isPresent()) {
			throw new Exception("category doesnot exist to put the item ");
		}

		p.setCategory(findById.get());

		if (productImageUpload.uploadFile(file)) {
			p.setImage(file.getOriginalFilename());
		} else {
			throw new Exception("file not uploaded ");
		}

		return productDao.save(p);
	}

	// update
	public Product updateProduct(Product p, int categoryId, MultipartFile file) throws Exception {

		Optional<Category> findById = categoryDao.findById(categoryId);
		if (!findById.isPresent()) {
			throw new Exception("category doesnot exist to put the item ");
		} else {
			p.setCategory(findById.get());
			if (file.isEmpty()) {
				Optional<Product> findById2 = productDao.findById(p.getId());
				p.setImage(findById2.get().getImage());
			} else {
				if (productImageUpload.uploadFile(file)) {
					p.setImage(file.getOriginalFilename());
				} else {
					throw new Exception("file not uploaded ");
				}
			}
		}

		return productDao.save(p);
	}

	// delete
	public void deleteProduct(int id) throws Exception {
		Optional<Product> findById = productDao.findById(id);
		if (findById.isPresent()) {
			productDao.deleteById(id);
		} else {
			throw new Exception("category doesnot exist to delete");
		}
	}
}
