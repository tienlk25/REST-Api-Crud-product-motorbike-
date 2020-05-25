package com.tienlk25.error;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tienlk25.RestResponse.ErrorMessage;
import com.tienlk25.exceptiones.NotFoundId;
import com.tienlk25.exceptiones.OptionCheckingException;

@ControllerAdvice
public class ProductGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundId.class)
	public ResponseEntity<?> notFoundIdProduct(Exception e, WebRequest request, HttpServletResponse response) throws IOException{
		ErrorMessage error = new  ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OptionCheckingException.class)
	public ResponseEntity<?> optionCheckingException(Exception e, WebRequest request, HttpServletResponse response) throws IOException{
		ErrorMessage error = new  ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	// error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }
}
