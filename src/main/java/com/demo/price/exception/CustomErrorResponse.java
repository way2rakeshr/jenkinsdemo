package com.demo.price.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author hemanth.garlapati
 * 
 */
public class CustomErrorResponse {
	
	private int errorCode;
	private String message;
	private List<String> details;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;


	public CustomErrorResponse() {
		super();
	}
	/**
	 * @param errorCode
	 * @param message
	 * @param details
	 * @param timestamp
	 */
	public CustomErrorResponse(int errorCode, String message, List<String> details, LocalDateTime timestamp) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
