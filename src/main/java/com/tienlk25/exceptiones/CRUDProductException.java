package com.tienlk25.exceptiones;

public class CRUDProductException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6359562954212724383L;

	public CRUDProductException (String messsage) {
		super(messsage);
	}
}
