package com.lucian.dgaspc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


/*
 * https://www.codejava.net/frameworks/spring-boot/spring-security-fix-deprecated-methods
*/

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
			auth -> auth.requestMatchers("/signin", "/signup").permitAll()
			.requestMatchers("/super/**", "/superapps/**").hasAuthority("SUPER")
			.requestMatchers("/admin/**").hasAuthority("ADMIN")
			.requestMatchers("/**").permitAll()
			.anyRequest().authenticated()
		)
		.formLogin(formLogin -> formLogin
			.loginPage("/signin")
			.loginProcessingUrl("/login")
			.permitAll()
		)
		.rememberMe(withDefaults())
		.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.permitAll());
		return http.build();
	}
}

