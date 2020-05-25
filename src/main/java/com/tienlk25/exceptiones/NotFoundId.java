package com.tienlk25.exceptiones;



public class NotFoundId extends RuntimeException{

	private String messges;
	
	public NotFoundId(Integer id) {
        this.messges = "Not found id: " + id;
    }

	public String getMessges() {
		return messges;
	}

	public void setMessges(String messges) {
		this.messges = messges;
	}
	
	
}
