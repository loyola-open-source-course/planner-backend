package com.loyola.planner.config;

import com.loyola.planner.repositories.UsersRepository;
import com.loyola.planner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-30
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/**").permitAll()
                    .antMatchers("/actuator/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .cors().disable()
                    .csrf().disable()
                    .logout().disable()
                    .formLogin().disable();
        // @formatter:on

    }

    @Autowired
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
