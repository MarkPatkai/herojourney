package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.request.UserHeroRequest;
import io.tearstar.herojourney.model.user.User;
import io.tearstar.herojourney.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/HeroJourney/hero/")
public class HeroController {

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/")
    private List<Hero> getHerosByUser(@RequestBody User user) {
        return heroService.getHeroesByUser(user);
    }

    @PostMapping("/")
    private Hero createHeroForUser(@RequestBody UserHeroRequest userHeroRequest) {
        return heroService.createHero(userHeroRequest);
    }
}
