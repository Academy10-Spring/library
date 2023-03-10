package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	protected InMemoryUserDetailsManager userDetailService() throws Exception {
		UserDetails user = User.builder()
			.username("user")
			.password(encoder().encode("root"))
			.roles("USER")
			.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
