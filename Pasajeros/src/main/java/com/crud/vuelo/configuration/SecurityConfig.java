package com.crud.vuelo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.crud.vuelo.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	
			private final JwtAuthenticationFilter jwtAuthenticationFilter;
		    private final AuthenticationProvider authProvider;
	
		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	    {
			return http
		            .csrf(csrf -> csrf.disable())
		            .headers(httpSecurityHeadersConfigurer -> {
		                httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
		             })
		            .authorizeHttpRequests(authRequest -> authRequest
		                .requestMatchers(
		                    "/auth/**", 
		                    "/v3/api-docs/**", 
		                    "/swagger-ui/**", 
		                    "/swagger-ui.html" ,
		                    "/h2-console/**",
		                    "/custom-path/**"
		                    ).permitAll()
		                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
		            )
		            .sessionManagement(sessionManager -> sessionManager
		                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		            )
		            .authenticationProvider(authProvider)
		            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
		            .build();	            
	            
	    }

}
