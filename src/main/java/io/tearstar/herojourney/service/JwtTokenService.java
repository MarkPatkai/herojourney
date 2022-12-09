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
import java.util.Arrays;
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

    @Value("${hero-journey.jwtSecret}")
    private String jwtSecret;

    public JwtTokenService(UserService userService) {
        this.userService = userService;
    }

    public String authenticate(@NonNull User user) throws AuthException {
        User usr = userService.findUser(user);
        if (usr == null) {
            throw new AuthException("User not found");
        }

        return generateToken(usr);
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXP_DATE);
        return Jwts.builder()
                .setSubject(user.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .claim("roles", user.getRole().getAuthorities())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            log.error("No JWT token found in request headers");
            filterChain.doFilter(request, response);
            return;
        }
        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!validateToken(token)) {
            filterChain.doFilter(request, response);
            log.error("Invalid token!");
            return;
        }

        User usr = null;
        try {
            usr = userService.findUserByName(getUserIdFromToken(token));
        } catch (AuthException e) {
            log.error("User not found!");
            filterChain.doFilter(request, response);
            return;
        }


        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                usr, null,
                usr == null ?
                        Collections.emptyList() : usr.getRole().getAuthorities()
        );


        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
