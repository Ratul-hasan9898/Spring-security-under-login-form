package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class Securityconfig {
@Bean
 public UserDetailsService userDetailsService(){
  UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("admin").build();
  UserDetails user = User.withUsername("user").password(passwordEncoder().encode("123")).roles("user").build();
  return new InMemoryUserDetailsManager(admin,user);
 }
 @Bean
 public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
 }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
   http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().formLogin();
   return http.build();
}
}
