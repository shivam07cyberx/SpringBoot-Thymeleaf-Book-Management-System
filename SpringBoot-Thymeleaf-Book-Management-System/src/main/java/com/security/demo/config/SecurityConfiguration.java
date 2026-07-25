package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration  {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	SecurityFilterChain securityfilterChain( HttpSecurity http) {
		
		
		http.csrf(c->c.disable()).authorizeHttpRequests(auth->
		
				auth.requestMatchers("/","/login","/register","/register_user","/images/**").permitAll()
				.requestMatchers("/users/**","/admin/user/**").hasRole("ADMIN")
				.requestMatchers("/dashboard","/books/**").hasAnyRole("USER","ADMIN").anyRequest().authenticated()
				
				
				).formLogin(form->form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/dashboard").permitAll());
		
		
		
		
		
	return	http.build();
		
		
		
		
	}
	
	

}
