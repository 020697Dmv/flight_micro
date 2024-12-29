package com.crud.vuelo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Dto.AuthResponse;
import com.crud.vuelo.models.Dto.RegisterRequest;
import com.crud.vuelo.models.Dto.loginDto;
import com.crud.vuelo.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {
	
	
    private final AuthService authService;

	
	@PostMapping(value="/login" , produces = "application/json")
	public ResponseEntity<AuthResponse> login( loginDto request ) {		
		
		loginDto login= new loginDto();
		
		login.setUsername("maira");
		login.setPassword("123456");

        return ResponseEntity.ok(authService.login(login));
	}

	@PostMapping(value="/register" , produces = "application/json")
	public ResponseEntity<AuthResponse> register( RegisterRequest request2 ) {
		
		RegisterRequest request = new RegisterRequest();
	    request.setUsername("maira");
	    request.setPassword("123456");
	    request.setFirstname("mai");
	    request.setLastname("h v");
	    request.setCountry("Colombia");
		 System.out.println("Received RegisterRequest: " + request2);
		    if (request2 == null) {
		        System.out.println("The request body is null!");
		    }
        return ResponseEntity.ok(authService.register(request));
	}
}
