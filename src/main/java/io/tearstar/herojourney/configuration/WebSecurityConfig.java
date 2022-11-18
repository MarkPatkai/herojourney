package io.tearstar.herojourney.configuration;

import io.tearstar.herojourney.service.JwtTokenService;
import io.tearstar.herojourney.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


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

        http = http.exceptionHandling().authenticationEntryPoint(((request, response, authException) ->
        {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        })).and();

        http.authorizeHttpRequests()
                .antMatchers("/HeroJorney/auth").permitAll()
                .antMatchers("/HeroJourney/user").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(
                jwtTokenService,
                UsernamePasswordAuthenticationFilter.class
        );
    }
}
