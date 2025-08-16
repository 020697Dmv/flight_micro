package com.crud.vuelo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.models.Role;
import com.crud.vuelo.models.Usuario;
import com.crud.vuelo.models.Dto.AuthResponse;
import com.crud.vuelo.models.Dto.LoginDto;
import com.crud.vuelo.models.Dto.RegisterRequest;
import com.crud.vuelo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        System.out.println("TOKEN GENERADO"+token);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

	
	public AuthResponse register(RegisterRequest request) {
		Usuario user= Usuario.builder()
				 .username(request.getUsername())
		            .password(passwordEncoder.encode( request.getPassword()))
		            .firstname(request.getFirstname())
		            .lastname(request.getLastname())
		            .country(request.getCountry())
		            .role(Role.USER)
		            .build();
		userRepository.save(user);
		  return AuthResponse.builder()
		            .token(jwtService.getToken(user))
		            .build();
		}
	
	public ResponseEntity<Usuario> user(LoginDto request) {
		
					
		 Optional<Usuario> optionalUsuario = userRepository.findByUsername(request.getUsername());

		    if (optionalUsuario.isPresent()) {
		        Usuario usuario = optionalUsuario.get();

		        if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
		            return new ResponseEntity<>(usuario, HttpStatus.OK);
		        } else {
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
		        }
		    }
		    
		    return ResponseEntity.noContent().build();

		}
}
