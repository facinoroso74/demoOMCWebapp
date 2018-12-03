package demo.restServices.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import demo.exception.PaymentNotFoundException;

@ControllerAdvice
public class PaymentAdvice {

	@ResponseBody
	@ExceptionHandler(PaymentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(PaymentNotFoundException ex) {
		return ex.getMessage();
	}
	
}
