package com.demo.price.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * 
 */

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	/**
	 * 
	 */
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception exception) {
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		CustomErrorResponse errorRepsonse = new CustomErrorResponse(500, "some error occured", details,
				LocalDateTime.now());
		return new ResponseEntity<>(errorRepsonse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductPrice.class)
	public ResponseEntity<ErrorResponse> handleProdductPrice(ProductPrice price){
		ErrorResponse er=new ErrorResponse();
		er.setMessage(price.getMessage());
		er.setStatusCode(1234);
		return new ResponseEntity<>(er, HttpStatus.OK);
		
		
		
	}
}
