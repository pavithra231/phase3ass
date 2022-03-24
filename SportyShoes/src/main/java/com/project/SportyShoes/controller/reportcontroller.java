package com.project.SportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.SportyShoes.entity.report;
import com.project.SportyShoes.service.reportservice;

@Controller
public class reportcontroller {
	
	@Autowired
	reportservice report;
	
	@RequestMapping("/listreport")
	public String viewListProductPage(Model model)
	{
		List<report> listreport= report.listAll();
		model.addAttribute("listreport", listreport);
		return "/report";
		
	}

}
