//webSecurityConfigurerAdapter is banned, http basic is also banned. 

package com.example.demo;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration  {
    @Autowired
    private UserService customUserDetailsService;

   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

        .formLogin(form -> form
                //.loginPage("/login") // Define a custom login page
                .permitAll() // Allow everyone to access the login page
                //.failureUrl("/login?error=true")
        )
                .logout(logout -> logout
                //.logoutUrl("/logout")
                //.logoutSuccessUrl("/login?logout")
                .permitAll()
                )
                .authorizeHttpRequests(authz -> authz
        .requestMatchers("/api/singers/all").hasAuthority("ADMIN")
        .requestMatchers("/api/singers/**").hasRole("USER")
        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
        .requestMatchers("/login", "/logout").permitAll()
        .anyRequest().authenticated() // Require authentication for all requests
            
            
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}

