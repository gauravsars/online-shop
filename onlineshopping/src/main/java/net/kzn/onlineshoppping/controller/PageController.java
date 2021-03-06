package net.kzn.onlineshoppping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshoppping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value ={"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Home");
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		return mv;	
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout", true);
		mv.addObject("title", "About Us");
		return mv;	
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;	
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllCategoryProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title", "All Products");
		return mv;	
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProductsById(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories",categoryDAO.list());
		//fetch the category by id
		Category category = categoryDAO.getCategoryById(id);
		mv.addObject("title", category.getName());
		mv.addObject("category",category);
		return mv;	
	}
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null){
			throw new ProductNotFoundException();
		}
		product.setViews(product.getViews()+1);
		//update the view count
		productDAO.update(product);
		mv.addObject("productInfo", product);
		mv.addObject("title", product.getName());
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	
	
	
}
