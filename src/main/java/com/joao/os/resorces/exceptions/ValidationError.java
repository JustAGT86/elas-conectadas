package com.joao.os.resorces.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.joao.os.services.exceptions.FieldMessage;

public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
			}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
}
