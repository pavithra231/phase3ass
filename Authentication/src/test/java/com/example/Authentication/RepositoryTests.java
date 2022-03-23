package com.example.Authentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;

@DataJpaTest
public class RepositoryTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void testwithoriginalEmail() {
		User user = new User();
		user.setName("Ananth");
		user.setEmail("ananth12@gmail.com");
		user.setPassword("Rakshana");
		entityManager.persist(user);
		entityManager.flush();
		
		User found = userRepository.findUserByEmail(user.getEmail());
		
		Assertions.assertTrue(found.getEmail()==user.getEmail());
		
	}
	
	@Test
	public void testwithwrongEmail() {
		User user = new User();
		user.setName("Ananth");
		user.setEmail("anangmail.com");
		user.setPassword("shana");
		entityManager.persist(user);
		entityManager.flush();
		
		User found = userRepository.findUserByEmail(user.getEmail());
		Assertions.assertFalse(found.getEmail()!=user.getEmail());
	}
}
