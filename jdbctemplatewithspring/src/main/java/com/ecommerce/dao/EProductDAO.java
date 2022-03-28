package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.entity.UserEntity;



public class EProductDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int findById(UserEntity e) {

        String query = "select * from users where id= "+e.getID();
        return template.update(query); 
    }
	
	public List<UserEntity> getusers()
	{
		return template.query("select * from users", 
				new RowMapper<UserEntity>() {

					public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserEntity e= new UserEntity();
						e.setID(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setEmail(rs.getString(3));
						e.setPassword(rs.getString(4));
						return e;
					}
			
		});
	}
	
		public int update(UserEntity e){  
		    String query="update users set name='"+e.getName()+"',email='"+e.getEmail()+"',password='"+e.getPassword()+"' where id='"+e.getID()+"'";  
		    return template.update(query);  
		}  
		
}
