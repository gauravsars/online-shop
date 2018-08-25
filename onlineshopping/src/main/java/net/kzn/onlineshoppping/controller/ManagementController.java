package net.kzn.onlineshoppping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshoppping.util.FileUploadUtility;
import net.kzn.onlineshoppping.validator.ProductValidator;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value ="/products",method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation" , required=false) String operation){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title","Manage Products");
		Product nproduct = new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		mv.addObject("product", nproduct);
		
		if(operation!=null){
			
			if(operation.equals("product")){
				mv.addObject("message","Product Submitted Successfully");
			}
			
		}
		return mv;
	}
	
	//returning categories for all the requests
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
		
	}
	
	//handling product submission
	@RequestMapping(value="/products" , method=RequestMethod.POST)
	public String handleFormSubmission(@Valid @ModelAttribute("product") Product mproduct, BindingResult results, Model model,HttpServletRequest request){
		//create a new product Record
		//check if there are any errors.
		
		new ProductValidator().validate(mproduct,results);
		
		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product details");
			return "page";
		}
		productDAO.add(mproduct);
		
		//file upload
		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
}
