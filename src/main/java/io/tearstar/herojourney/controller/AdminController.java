package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.service.DeveloperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HeroJourney/admin")
@Slf4j
public class AdminController {


    @GetMapping("/")
    public String getDeveloper() {
        return "OK";
    }




}
