//package com.cinemapackage.cinemaproject.securityconfiguration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//public class SecurityConfiguration 
//{
//	@Bean
//	public AuthenticationManager configureGlobal(AuthenticationManagerBuilder auth) throws Exception
//	{
//		
//		auth.inMemoryAuthentication().withUser("Hello")
//			.password("Entry")
//			.roles("USER")
//			.and()
//			.withUser("Soumik")
//			.password("1st-user")
//			.roles("ADMIN");
//		
//		return auth.build();
//	}
//	
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	
////	protected void configure(HttpSecurity http) throws Exception
////	{
////		http.authorizeHttpRequests()
////			.requestMatchers("/**")
////			.hasRole("ADMIN")
////			.and().formLogin();
////		
////	}
//	
//	
//
//
//}
