package com.springcourse.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashUtilTest {

	@Test
	public void getSecureHashTest() {
		String hash = HashUtil.getSecureHash("1234");
		System.out.println(hash);
		
		assertEquals(hash.length(), 64);
	}
}
