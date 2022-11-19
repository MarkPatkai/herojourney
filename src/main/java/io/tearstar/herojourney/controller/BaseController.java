package io.tearstar.herojourney.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/HeroJourney")
public class BaseController {

    @GetMapping("/")
    public String index() {
        log.info("BaseController.index()");
        return "HeroJourney";
    }
}
