package com.project.SportyShoes.jdbc;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.SportyShoes.entity.Categories;
import com.project.SportyShoes.entity.UserDetails;


public interface CategoriesRepository extends JpaRepository<Categories, Long> {


	public List<UserDetails> save(String categoryName);

}
