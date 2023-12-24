package com.green.supermarketwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.green.supermarketwebapp.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private final UserDetailsServiceImpl userDetailsService;

  public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
            .requestMatchers("/register", "/product/**", "/**").permitAll()
            .requestMatchers("/user/**").hasRole("CUSTOMER")
            .requestMatchers("/manager/**").hasRole("MANAGER"))
        .formLogin(formLogin -> formLogin
            .loginPage("/login")
            .permitAll()
            .usernameParameter("email")
            .passwordParameter("password"))
        .logout(logout -> logout
            .logoutUrl("/logout").permitAll());

    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
