package com.project.SportyShoes.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "report")
@Table(name="report")
public class report{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public String username;
	public String phone;
	public String productPerchased;
	public Date perchaseDate;
	public String category;
	public report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public report(String username, String phone, String productPerchased,
			Date perchaseDate, String category) {
		super();
		
		this.username = username;
		this.phone = phone;
		this.productPerchased = productPerchased;
		this.perchaseDate = perchaseDate;
		this.category = category;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProductPerchased() {
		return productPerchased;
	}
	public void setProductPerchased(String productPerchased) {
		this.productPerchased = productPerchased;
	}
	public Date getPerchaseDate() {
		return perchaseDate;
	}
	public void setPerchaseDate(Date perchaseDate) {
		this.perchaseDate = perchaseDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	

}
