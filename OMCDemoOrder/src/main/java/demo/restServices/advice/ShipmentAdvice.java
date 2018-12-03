package demo.restServices.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import demo.exception.ShipmentNotFoundException;

@ControllerAdvice
public class ShipmentAdvice {

	@ResponseBody
	@ExceptionHandler(ShipmentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String orderNotFoundHandler(ShipmentNotFoundException ex) {
		return ex.getMessage();
	}
	
}
