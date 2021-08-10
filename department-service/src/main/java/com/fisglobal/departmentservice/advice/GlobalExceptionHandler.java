package com.fisglobal.departmentservice.advice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fisglobal.departmentservice.exception.ResourceNotFound;
import com.fisglobal.departmentservice.utils.ErrorDetails;

@ControllerAdvice //whenever any exception is coming inside the controller package it will be handle by globalException if it is declared
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFound ex,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false) );
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false) );
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails details=new ErrorDetails(new Date(), ex.getMessage(), "validation failed");
		return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
		// TODO Auto-generated method stub
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
}
