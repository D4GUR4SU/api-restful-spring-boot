package com.springcourse.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

	private HashUtil(){

	}

	public static String getSecureHash(String text) {
		return DigestUtils.sha256Hex(text);
	}
}
