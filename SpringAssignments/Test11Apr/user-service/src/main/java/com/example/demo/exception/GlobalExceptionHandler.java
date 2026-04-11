package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.*;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> handleProductNotFound(UserNotFoundException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("User not found exception: ", ex.getMessage());
		return error;
	}

}