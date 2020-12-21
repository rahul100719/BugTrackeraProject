package com.example.demo.exceptions;

import java.util.Date;
/*
 * Uniform Exception Response across the project
 * */
public class ExceptionResponse {
	
	private Date timestampDate;
	private String message;
	/**
	 * @return the timestampDate
	 */
	public Date getTimestampDate() {
		return timestampDate;
	}
	/**
	 * @param timestampDate the timestampDate to set
	 */
	public void setTimestampDate(Date timestampDate) {
		this.timestampDate = timestampDate;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionResponse(Date timestampDate, String message) {
		super();
		this.timestampDate = timestampDate;
		this.message = message;
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
