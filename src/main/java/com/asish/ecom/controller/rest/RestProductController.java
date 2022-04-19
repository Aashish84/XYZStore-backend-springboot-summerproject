package com.asish.ecom.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asish.ecom.entities.Product;
import com.asish.ecom.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class RestProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct() throws Exception {
		return ResponseEntity.ok().body(productService.getAllProduct());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok().body(productService.getProduct(id));
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok().body(productService.getProductByCategory(id));
	}

	// view-image
	@GetMapping("/image/{name}")
	public ResponseEntity<InputStreamResource> viewImage(@PathVariable("name") String imageName)
			throws FileNotFoundException {

		File file = new File("D:\\spring-tool-suite\\spring-boot-workspace\\ecom\\src\\main\\resources\\static\\image\\"
				+ imageName);
		InputStream in = new FileInputStream(file);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(in));

	}

	@PostMapping
	public Product addProduct(@RequestBody Product p) throws Exception {
		return productService.addProduct(p);
	}

}
