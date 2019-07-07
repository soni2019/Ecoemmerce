package com.hcl.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8207405045279450965L;

	public DataNotFoundException(String exception) {
		super(exception);
		}
}
