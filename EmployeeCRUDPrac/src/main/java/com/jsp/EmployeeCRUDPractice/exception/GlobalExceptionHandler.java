package com.jsp.EmployeeCRUDPractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.EmployeeCRUDPractice.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception){
		ResponseStructure<String> res=new ResponseStructure<>();
		res.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage("Id Not found ");
		res.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecordFoundException(NoRecordFoundException exception){
		ResponseStructure<String> res=new ResponseStructure<>();
		res.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage("No record found");
		res.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.NOT_FOUND);
	}
}
