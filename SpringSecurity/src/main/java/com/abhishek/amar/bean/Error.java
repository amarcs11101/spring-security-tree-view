/**
 * 
 */
package com.abhishek.amar.bean;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * @author Abhishek Amar
 *
 */
public class Error {
	private String message;
	private HttpStatus status;
	private Date timeStamp;

	public Error(String message, HttpStatus status, Date timeStamp) {
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}
}
