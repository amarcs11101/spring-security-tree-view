/**
 * 
 */
package com.abhishek.amar.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abhishek.amar.bean.Error;

/**
 * @author Abhishek Amar
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/error")
public class ErrorController {
	
	@GetMapping 
	public ResponseEntity<Object> handleError() {
		return new ResponseEntity<>(new Error("Unauthorized access", HttpStatus.BAD_REQUEST, new Date()),
				HttpStatus.OK);
	}
}
