package demo.restServices.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import demo.exception.ShoesNotFoundException;

@ControllerAdvice
public class ShoesAdvice {

	@ResponseBody
	@ExceptionHandler(ShoesNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ShoesNotFoundException ex) {
		return ex.getMessage();
	}
	
}
