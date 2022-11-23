package com.asish.ecom.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asish.ecom.entities.Category;
import com.asish.ecom.entities.Product;
import com.asish.ecom.service.CategoryService;
import com.asish.ecom.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	// view-post
	@RequestMapping(method = RequestMethod.GET)
	public String displayView(Model m) throws Exception {
		List<Product> productWithLimit = productService.getProductWithLimit();
		m.addAttribute("allData", productWithLimit);
		return "admin/product/view-post";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String displayView(@RequestParam("searchtxt") String searchTxt, Model m) throws Exception {

		List<Product> allProduct = productService.getProductByName(searchTxt.trim());
		m.addAttribute("searchKey", searchTxt);
		m.addAttribute("allData", allProduct);
		return "admin/product/view-post";
	}

	// view-image
	@RequestMapping(path = "/image-view/{name}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> viewImage(@PathVariable("name") String imageName)
			throws FileNotFoundException {

		File file = new File("D:\\spring-tool-suite\\spring-boot-workspace\\ecom\\src\\main\\resources\\static\\image\\"
				+ imageName);
		InputStream in = new FileInputStream(file);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(in));

	}

	// add-post
	@RequestMapping(path = "/add-post", method = RequestMethod.GET)
	public String addView(Model m) {
		List<Category> categoryWithFilter = categoryService.getCategoryWithFilter("active");
		m.addAttribute("allActiveCategoryData", categoryWithFilter);
		return "admin/product/add-post";
	}

	@RequestMapping(path = "/add-post", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product p, @RequestParam("category_id") int cid,
			@RequestParam("file") MultipartFile file, Model m) throws Exception {

		Product addProduct = productService.addProduct(p, cid, file);
		List<Product> tmp = new ArrayList<>();
		tmp.add(addProduct);
		m.addAttribute("allData", tmp);
		return "admin/product/view-post";
	}

	// update-post
	@RequestMapping(path = "/update-post/{id}", method = RequestMethod.GET)
	public String updateView(@PathVariable("id") int id, Model m) throws Exception {

		List<Category> categoryWithFilter = categoryService.getCategoryWithFilter("active");
		m.addAttribute("allActiveCategoryData", categoryWithFilter);

		Product product = productService.getProduct(id);
		m.addAttribute("data", product);
		return "admin/product/update-post";
	}

	@RequestMapping(path = "/update-post/{id}", method = RequestMethod.POST)
	public String updateView(@PathVariable("id") int id, @ModelAttribute Product p,
			@RequestParam("category_id") int cid, @RequestParam(name = "file", required = false) MultipartFile file,
			Model m) throws Exception {

		Product updateProduct = productService.updateProduct(p, cid, file);
		List<Product> tmp = new ArrayList<>();
		tmp.add(updateProduct);
		m.addAttribute("allData", tmp);
		return "admin/product/view-post";
	}

	// delete-post
	@RequestMapping(path = "/delete-post/{id}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable int id) throws Exception {
		productService.deleteProduct(id);
		return "redirect:/admin/product";
	}
}
