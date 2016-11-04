package com.ironpeter.springdemo.util;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class UTF8Tools {

	public ResponseEntity<String> transferUTF8(String s) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("text", "html",
				Charset.forName("UTF-8"));
		headers.setContentType(mediaType);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(s,
				headers, HttpStatus.OK);
		return responseEntity;
	}
}
