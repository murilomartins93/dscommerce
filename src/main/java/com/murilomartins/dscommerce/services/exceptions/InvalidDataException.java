package com.murilomartins.dscommerce.services.exceptions;

import org.springframework.validation.BindingResult;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private BindingResult bindingResult;

	public InvalidDataException(String msg, BindingResult result) {
		super(msg);
		this.bindingResult = result;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}
	
}
