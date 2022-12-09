package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.exceptions.AuthException;
import io.tearstar.herojourney.model.user.User;
import io.tearstar.herojourney.service.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/HeroJourney/auth/")
@Slf4j
@RestController
public class AuthController {

    JwtTokenService jwtTokenService;

    public AuthController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/")
    private String auth(@RequestBody User user) throws AuthException {
        return jwtTokenService.authenticate(user);
    }

}
