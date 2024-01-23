package com.springcourse.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.User;
import com.springcourse.enums.Role;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired 
	private UserRepository userRepository;
	
	
	@Test
	public void saveTest() {
		User user = new User(null, "Douglas", "douglas@email.com", "1234", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertEquals(createdUser.getId(), user.getId());
	}
	
	@Test
	public void updateTest() {
		User user = new User(1L, "Douglas Souza", "douglas@email.com", "1234", Role.ADMINISTRATOR, null, null);
		User updatedUser = userRepository.save(user);
		
		assertEquals(updatedUser.getName(), "Douglas Souza");
	}
	
	@Test
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();
		
		assertEquals(user.getPassword(), "1234");
	}
	
	@Test
	public void listTest() {
		List<User> users = userRepository.findAll();
		
		assertEquals(users.size(), 1);
	}
	
	@Test
	public void loginTest() {
		User user = new User(1L, "Douglas", "douglas@email.com", "1234", Role.ADMINISTRATOR, null, null);
		Optional<User> result = userRepository.login(user.getEmail(), user.getPassword());
		User loggedUser = result.get();
		
		assertEquals(loggedUser.getId(), result.get().getId());
	}
}
