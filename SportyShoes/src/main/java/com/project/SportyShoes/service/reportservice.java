package com.project.SportyShoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SportyShoes.jdbc.reportrepo;
import com.project.SportyShoes.entity.report;

@Service
@Transactional
public class reportservice {

	@Autowired
	public reportrepo report;
	
	public List<report> listAll()
	{
		return report.findAll();
	}


}
