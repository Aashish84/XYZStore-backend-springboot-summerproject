package com.asish.ecom.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asish.ecom.entities.Category;
import com.asish.ecom.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// main view
	@RequestMapping(method = RequestMethod.GET)
	public String displayView() {
		return "admin/category/view-post";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String displayByName(@RequestParam("cname") String name, Model m) {
		List<Category> categoryByName = categoryService.getCategoryByName(name);
		m.addAttribute("allData", categoryByName);
		return "admin/category/view-post";
	}

	@RequestMapping(path = "/{filter}", method = RequestMethod.GET)
	public String displayAll(@PathVariable String filter, Model m) {
		List<Category> allCategory = categoryService.getCategoryWithFilter(filter);
		m.addAttribute("allData", allCategory);
		m.addAttribute("filter", filter);
		return "admin/category/view-post";
	}

	// add-post
	@RequestMapping(path = "/add-post", method = RequestMethod.GET)
	public String addNewCategoryView() {
		return "admin/category/add-post";
	}

	@RequestMapping(path = "/add-post", method = RequestMethod.POST)
	public String addNewCategory(@ModelAttribute Category c) throws Exception {
		categoryService.addCategory(c);
		return "redirect:/admin/category/all";
	}

	// update-post
	@RequestMapping(path = "/update-post/{id}", method = RequestMethod.GET)
	public String updateCategoryView(@PathVariable int id, Model m) {
		Category oneCategoryById = categoryService.getOneCategoryById(id);
		m.addAttribute("category", oneCategoryById);
		return "admin/category/update-post";
	}

	@RequestMapping(path = "/update-post/{id}", method = RequestMethod.POST)
	public String updateCategory(@PathVariable int id, Model m, @ModelAttribute Category c) throws Exception {
		Category updateCategory = categoryService.updateCategory(id, c);
		List<Category> tmp = new ArrayList<>();
		tmp.add(updateCategory);
		m.addAttribute("allData", tmp);
		return "/admin/category/view-post";
	}

	// delete-post
	@RequestMapping(path = "/delete-post/{id}", method = RequestMethod.POST)
	public String deleteCategory(@PathVariable int id) throws Exception {
		categoryService.deleteCategory(id);
		return "redirect:/admin/category/all";
	}

}
