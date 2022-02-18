package com.greetings.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.greetings.api.dto.GreetingRequest;
import com.greetings.api.dto.GreetingResponse;

@RestController
public class GreetingsController {
	
	@PostMapping(value = "/greet",  produces = "application/json;charset=UTF-8")
	public ResponseEntity<GreetingResponse> greet(@Valid @ModelAttribute("greetingRequest") GreetingRequest greetingRequest,
			@RequestHeader(value = "Accept-Language", required = false, defaultValue = "en_LU") String locale,
			BindingResult validationResult, HttpServletRequest request){
		GreetingResponse greetingResponse = new GreetingResponse();
		greetingResponse.setMessage("hello ! " + greetingRequest.getName() + " you are welcome to the party!!!");
		HttpStatus responseStatusCode = HttpStatus.OK;
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(greetingResponse, responseHeaders, responseStatusCode);
	}
	
	@GetMapping(value = "/greet",  produces = "application/json;charset=UTF-8")
	public ResponseEntity<GreetingResponse> greetEveryone(HttpServletRequest request){
		GreetingResponse greetingResponse = new GreetingResponse();
		greetingResponse.setMessage("hello Anonoumous! you are welcome to the party but POST it if you want personalised message!!!");
		HttpStatus responseStatusCode = HttpStatus.OK;
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(greetingResponse, responseHeaders, responseStatusCode);
	}
}
