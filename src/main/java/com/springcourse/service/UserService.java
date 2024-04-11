package com.springcourse.service;

import java.util.List;
import java.util.Optional;

import com.springcourse.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.repository.UserRepository;
import com.springcourse.service.util.HashUtil;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User save(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);

		return userRepository.save(user);
	}
	
	public User update(User user, Long id) {
		user.setId(id);
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);

		return userRepository.save(user);
	}
	
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
    return result.orElseThrow(() -> new NotFoundException("There are not user with id: " + id));
	}
	
	public List<User> listAll() {
		return userRepository.findAll();
	}
	
	public User login(String email, String password) {
		password = HashUtil.getSecureHash(password);
		
		Optional<User> result = userRepository.login(email, password);
		return result.orElseThrow(() -> new NotFoundException("There are not user with this login."));
	}
}
