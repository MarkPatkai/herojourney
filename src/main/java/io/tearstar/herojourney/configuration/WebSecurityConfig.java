package io.tearstar.herojourney.configuration;

import io.tearstar.herojourney.service.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import javax.servlet.http.HttpServletResponse;


@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    JwtTokenService jwtTokenService;

    public WebSecurityConfig(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();
        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        // Cors filter
        http = http.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class);

        http = http.exceptionHandling().authenticationEntryPoint(((request, response, authException) ->
        {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        })).and();

        http.authorizeHttpRequests()
                .antMatchers("/HeroJourney/**").permitAll()
                .antMatchers("/HeroJorney/auth").permitAll()
                .antMatchers("/HeroJourney/user").permitAll()
                .anyRequest().permitAll();

        http.addFilterBefore(
                jwtTokenService,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
