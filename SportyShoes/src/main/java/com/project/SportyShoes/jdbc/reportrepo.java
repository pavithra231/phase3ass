package com.project.SportyShoes.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SportyShoes.entity.report;

@Repository
public interface reportrepo extends JpaRepository<report, String> {

	public List<report> findAll();
	

}
