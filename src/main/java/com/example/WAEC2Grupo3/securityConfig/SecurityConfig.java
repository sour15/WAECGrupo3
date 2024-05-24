package com.example.WAEC2Grupo3.securityConfig;

import com.example.WAEC2Grupo3.service.DetalleUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private DetalleUsuarioService detalleUsuarioService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(
                                        "/auth/login",
                                        "/auth/registrar",
                                        "/resources/**",
                                        "/backoffice/**",
                                        "/static/**",
                                        "/css/**",
                                        "/js/**").permitAll()
                                .anyRequest().permitAll()
                ).formLogin(
                        login ->
                                login.loginPage("/auth/login")
                                        .defaultSuccessUrl("/auth/login-success")
                                        .usernameParameter("nomusuario")
                                        .passwordParameter("password")
                ).logout(
                        logout ->
                                logout.logoutSuccessUrl("/auth/login")
                                        .invalidateHttpSession(true)
                ).authenticationProvider(authenticationProvider());
        return http.build();
    }

    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

}
