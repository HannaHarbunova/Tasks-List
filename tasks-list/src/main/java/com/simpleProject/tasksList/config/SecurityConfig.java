package com.simpleProject.tasksList.config;

import com.simpleProject.tasksList.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private PasswordEncoder passwordEncoder;
//    private UserAuthService authService;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Autowired
//    public void setAuthService(UserAuthService authService) {
//        this.authService = authService;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/**").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/authenticateTheUser")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .permitAll();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(authService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//        return authenticationProvider;
//    }
//}

@Configuration
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserAuthService authService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, UserAuthService authService) {
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
