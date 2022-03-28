package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.EProductDAO;
import com.ecommerce.entity.UserEntity;

@Controller
public class MainController {

	@Autowired
	EProductDAO eproductDAO;
	private int id;
	
	@GetMapping("/list")
	public String listusers(ModelMap map)
	{
		List<UserEntity> list=eproductDAO.getusers();
		map.addAttribute("list",list);
		return "listusers";
	}
	@GetMapping("/search")
	 public String findById(ModelMap map,@RequestParam(name="ID")String ID) {
		    this.id=Integer.parseInt(ID);
		    UserEntity user=new UserEntity();
		    user.setID(id);
			eproductDAO.findById(user);
			map.addAttribute("user",user);
			return "search";		
	 }

	@GetMapping("/update")
	 public String update(ModelMap map,@RequestParam(name="name")String name, @RequestParam(name="email")String email,@RequestParam(name="password")String password) {
		    UserEntity user=new UserEntity();
		    user.setID(id);
		    user.setName(name);
		    user.setEmail(email);
		    user.setPassword(password);

			eproductDAO.update(user);
			map.addAttribute("user",user);
			return "updateresult";
			
	 }
	
}
