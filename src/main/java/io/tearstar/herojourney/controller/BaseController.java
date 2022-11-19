package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/HeroJourney")
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "HeroJourney";
    }
    @GetMapping("/me")
    public User me() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
