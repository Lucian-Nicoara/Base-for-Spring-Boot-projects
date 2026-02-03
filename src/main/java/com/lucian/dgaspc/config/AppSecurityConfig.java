package com.lucian.dgaspc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;


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
		//http.csrf(AbstractHttpConfigurer::disable);
		http.headers(header->{header.frameOptions(FrameOptionsConfig::disable);}); //pt. fisiere embeded
		http.authorizeHttpRequests(
			auth -> auth.requestMatchers("/signin", "/signup").permitAll()
			.requestMatchers("/super/**", "/superapps/**").hasAuthority("SUPER")
			.requestMatchers("/admin/**").hasAuthority("Administrator")
			.requestMatchers("/images/**").permitAll()
			.requestMatchers("/scripts/**").permitAll()
			.requestMatchers("/styles/**").permitAll()
			//.requestMatchers("/**").permitAll()
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

	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("*"));
	 * configuration.setAllowedHeaders(Arrays.asList("*"));
	 * configuration.setAllowCredentials(true); UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/**", configuration); return source; }
	 */
}

