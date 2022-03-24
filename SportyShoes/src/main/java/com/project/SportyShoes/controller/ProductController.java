package com.project.SportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.SportyShoes.entity.Categories;
import com.project.SportyShoes.entity.Product;
import com.project.SportyShoes.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	public ProductService prodserv;
	private int Id;
	private int Price;

	
	@RequestMapping("/listprod")
	public String viewListProductPage(Model model)
	{
		List<Product> listProduct= prodserv.listAll();
		model.addAttribute("listProduct", listProduct);
		return "product_manage";
		
	}
	
	@RequestMapping("/newproduct")
	public String addNewProductPage(Model model)
	{
		Product product= new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("product") Product product, Model md) 
	{   
		
		prodserv.save(product);
		List<Product> listProduct= prodserv.listAll();
		md.addAttribute("listProduct", listProduct);
		
		return "product_manage";
	
	}
	
	@RequestMapping("/deleteprod/{id}")
	public String deleteproduct(@PathVariable(name ="id") long id, Model m)
	{
	    prodserv.deleteprod(id);
		List<Product> listproduct= prodserv.listAll();
		m.addAttribute("listproduct", listproduct);
		
		return "product_manage";
	}
	
	@RequestMapping("/updateprod")
	public String updateproduct()
	{	
		return "/updateproduct";
	}
		
	@RequestMapping(value="/product_update")
	public String updateproduct(ModelMap model,@RequestParam("id")String id, @RequestParam("productName")String productName,@RequestParam("category")String category,@RequestParam("price")String price, @RequestParam("size")String size) {

		this.Id = Integer.parseInt(id);
		this.Price=Integer.parseInt(price);

		Product p=new Product();
		p.setId(Id);
		p.setProductName(productName);
		p.setCategory(category);
		p.setPrice(Price);
		p.setSize(size);
		p.setStatus(true);
		prodserv.save(p);
		model.addAttribute("p", p);
		return "update";
		} 
	

}
