package com.abhishek.amar.exceptionhandler;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException() {
		super();
	}

	public PlayerNotFoundException(String exception) {
		super(exception);
	}
}
