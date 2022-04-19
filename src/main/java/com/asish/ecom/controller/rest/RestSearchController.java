package com.asish.ecom.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asish.ecom.entities.Product;
import com.asish.ecom.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class RestSearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping
	public ResponseEntity<List<Product>> searchItems(@RequestParam("searchKey") String searchKey) {
		List<Product> searchItem = searchService.searchItem(searchKey);
		if (searchItem.size() == 0) {
			return ((BodyBuilder) ResponseEntity.notFound()).body(null);
		}
		return ResponseEntity.ok().body(searchItem);
	}
}
