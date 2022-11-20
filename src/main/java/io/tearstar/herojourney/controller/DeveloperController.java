package io.tearstar.herojourney.controller;

import com.fasterxml.jackson.core.JsonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HeroJourney/developer")
@Slf4j
public class DeveloperController {

    @GetMapping("/")
    public String getDeveloper() {
        return "OK";
    }

}
