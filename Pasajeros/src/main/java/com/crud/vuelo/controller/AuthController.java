package com.crud.vuelo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Dto.AuthResponse;
import com.crud.vuelo.models.Dto.RegisterRequest;
import com.crud.vuelo.models.Dto.LoginDto;
import com.crud.vuelo.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {
	
	
    private final AuthService authService;

	
    @Operation(summary = "Login", description = "Servicio obtener autentificacion")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PostMapping(value="/login", produces = "application/json")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginDto request ) {		
		
		return ResponseEntity.ok(authService.login(request));
	}

	@PostMapping(value="/register" , produces = "application/json")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request ) {
		
	        return ResponseEntity.ok(authService.register(request));
	}
}
