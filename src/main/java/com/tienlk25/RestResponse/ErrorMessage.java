package com.tienlk25.RestResponse;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;
    
	public ErrorMessage(HttpStatus statusCode, String message) {
		super();
		this.httpStatus = statusCode;
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus statusCode) {
		this.httpStatus = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
    
    
}
