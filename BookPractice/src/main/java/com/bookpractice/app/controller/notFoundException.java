package com.bookpractice.app.controller;

public class notFoundException extends RuntimeException {
	notFoundException(Integer id) {
		super("Could not find book id: " + id);
	}

}
