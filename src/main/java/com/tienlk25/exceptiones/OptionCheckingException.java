package com.tienlk25.exceptiones;

public class OptionCheckingException extends RuntimeException {

	private String message;
	public OptionCheckingException() {
        this.message = "Option id not found!";
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
}
