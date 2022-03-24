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
import com.project.SportyShoes.service.CategoriesService;



@Controller
public class CategoriesController {
	
	@Autowired
	private CategoriesService catserv;
	private int Id;
	
	@RequestMapping("/listcat")
	public String viewListPage(Model model)
	{
		List<Categories> listCategories= catserv.listAll();
		model.addAttribute("listCategories", listCategories);
		return "manage";
		
	}
	
	@RequestMapping("/new")
	public String addNewCatPage(Model model)
	{
		Categories categories= new Categories();
		model.addAttribute("categories", categories);
		
		return "new_category";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("categories") Categories categories, Model m) 
	{   
		
		catserv.save(categories);
		List<Categories> listCategories= catserv.listAll();
		m.addAttribute("listCategories", listCategories);
		
		return "manage";
	
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteCategory(@PathVariable(name ="id") long id, Model m)
	{
		catserv.delete(id);
		List<Categories> listCategories= catserv.listAll();
		m.addAttribute("listCategories", listCategories);
		
		return "manage";
	}

	@RequestMapping("/search/{id}")
	public String searchCategory(@PathVariable(name ="id") long id, Model m)
	{
		catserv.get(id);
		List<Categories> listCategories= catserv.listAll();
		m.addAttribute("listCategories", listCategories);
		
		return "manage";
	}
	
	@RequestMapping("/update")
	public String updateCategory()
	{	
		return "/updateuser";
	}
		
	@RequestMapping(value="/process_update")
	public String updateUser(ModelMap model,@RequestParam("id")String id, @RequestParam("categoryName")String categoryName) {

		this.Id = Integer.parseInt(id);
		Categories cat=new Categories();
		cat.setId(Id);
		cat.setCategoryName(categoryName);
		catserv.save(cat);
		model.addAttribute("cat", cat);
		return "update";
		} 
		
	@RequestMapping("/return")
	public String returnpage()
	{	
		return "/menu";
	}
	

}
