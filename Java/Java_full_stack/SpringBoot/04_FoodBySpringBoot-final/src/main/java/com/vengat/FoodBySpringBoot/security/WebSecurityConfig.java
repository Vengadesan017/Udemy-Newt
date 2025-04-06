package com.vengat.FoodBySpringBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private static final String[] WHITELIST = {
        "/",
        "/login",
        "/register",
        "/admin",
        "/db-console/**",
        "/css/**",
        "/fonts/**",
        "/images/**",
        "/static/**",
        "/forgot-password",
        "/change-password",
        "/reset-password",
        "/api/v1/**",
        "/js/**"
};


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");  // Allow all origins for CORS
            }
        };
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(WHITELIST).permitAll()
                .requestMatchers("/posts/{id}").authenticated()
                .requestMatchers("/posts/{id}/edit").authenticated()
                .requestMatchers("/posts/{id}/delete").authenticated()
                .requestMatchers("profile").authenticated()
                .requestMatchers("/static/**").authenticated()
                .requestMatchers("/css/**").authenticated()
                .requestMatchers("/js/**").authenticated()
                .requestMatchers("/resources/**").authenticated()
                .requestMatchers("//api/v1/**").authenticated()
                .requestMatchers("/update_photo/**").authenticated()
                .requestMatchers("/posts/add/**").authenticated()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/editor/**").hasAnyRole("ADMIN", "EDITOR")
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("email").passwordParameter("password")
                .defaultSuccessUrl("/", true).failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .and()
                .httpBasic();

        // TODO: remove these after upgrading the DB from H2 infile DB
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}


