package com.medico.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
public class SecurityConfig {


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService users(PasswordEncoder encoder) {
    UserDetails user = User.withUsername("user")
      .password(encoder.encode("user"))
      .roles("USER")
      .build();

    UserDetails admin = User.withUsername("admin")
      .password(encoder.encode("admin"))
      .roles("ADMIN")
      .build();

    UserDetails vendor = User.withUsername("vendor")
      .password(encoder.encode("vendor"))
      .roles("VENDOR")
      .build();

    return new InMemoryUserDetailsManager(user, admin, vendor);
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())              // simple example
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/public/**", "/login").permitAll()
        .requestMatchers("/admin").hasRole("ADMIN")
        .requestMatchers("/user").hasRole("USER")
        .requestMatchers("/vendor").hasRole("VENDOR")
        .anyRequest().authenticated()
      )
      .formLogin(Customizer.withDefaults())  // fprm login (browser)
      .httpBasic(Customizer.withDefaults());      // basic auth
    return http.build();
  }

}
