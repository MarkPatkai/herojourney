package io.tearstar.herojourney.service;

import graphql.com.google.common.collect.Lists;
import io.jsonwebtoken.*;
import io.tearstar.herojourney.model.exceptions.AuthException;
import io.tearstar.herojourney.model.user.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
@Slf4j
public class JwtTokenService extends OncePerRequestFilter {

    private UserService userService;

    private static final long EXP_DATE = 1270000;

    @Value("${herojourney.jwtSecret:herojourney}")
    private String jwtSecret;

    public JwtTokenService(UserService userService) {
        this.userService = userService;
    }

    public String authenticate(@NonNull User user) throws AuthException {
        User usr = userService.findUser(user);

        return Jwts.builder()
                .setSubject(usr.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() + EXP_DATE)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    private String getUsername(String jwt) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!validateJwtToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        User usr = null;
        try {
            usr = userService.findUserByName(getUsername(token));
        } catch (AuthException e) {
            e.printStackTrace();
        }


        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                usr, null,
                usr == null ?
                        Collections.emptyList() : null
        );


        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }
}
