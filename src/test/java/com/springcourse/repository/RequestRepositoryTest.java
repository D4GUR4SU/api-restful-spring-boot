package com.springcourse.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.enums.RequestState;

@SpringBootTest
public class RequestRepositoryTest {

	@Autowired
	private RequestRepository requestRepository;
	
	@Test
	public void saveTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(null, "Macbook Air m2", "Pretendo obter um macbook", new Date(), owner, RequestState.OPEN, null);
		Request createdRequest = requestRepository.save(request);
		
		assertEquals(createdRequest.getId(), 1L);
	}
	
	@Test
	public void updateTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(1L, "Macbook Air m2", "Pretendo obter um macbook, de 16GB", null, owner, RequestState.OPEN, null);
		Request updatedRequest = requestRepository.save(request);
		
		assertEquals(updatedRequest.getDescription(), "Pretendo obter um macbook, de 16GB");
	}
	
	@Test
	public void getByIdTest() {
		Optional<Request> result = requestRepository.findById(1L);
		Request request = result.get();
		
		assertEquals(request.getSubject(), "Macbook Air m2");
	}
	
	@Test
	public void listTest() {
		List<Request> requests = requestRepository.findAll();
		
		assertEquals(requests.size(), 1);
	}
	
	@Test
	public void listByOwnerIdTest() {
		List<Request> requests = requestRepository.findAllByOwnerId(1L);
		
		assertEquals(requests.size(), 1);
	}
	
	@Test
	public void updateStatusTest() {
		int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
		
		
		assertEquals(affectedRows, 1);
	}
}
