package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.base.hero.HeroClass;
import io.tearstar.herojourney.model.exceptions.AuthException;
import io.tearstar.herojourney.model.exceptions.ExceptionMessage;
import io.tearstar.herojourney.model.user.User;
import io.tearstar.herojourney.service.HeroService;
import io.tearstar.herojourney.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/HeroJourney/hero")
public class HeroController {

    private final HeroService heroService;
    private final UserService userService;

    public HeroController(HeroService heroService, UserService userService) {
        this.heroService = heroService;
        this.userService = userService;
    }

    @GetMapping("/")
    private List<Hero> getHerosByUser() throws AuthException {
        SecurityContext context = SecurityContextHolder.getContext();
        log.info("User: {}", context.getAuthentication());
        if (context.getAuthentication().getPrincipal().equals("anonymousUser")) {
            throw new AuthException("--anon--");
        }
        User user = (User) context.getAuthentication().getPrincipal();
        return heroService.getHeroesByUser(user);
    }

    @PostMapping("/")
    private Hero createHeroForUser(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @GetMapping("/hero_class")
    private List<HeroClass> getHeroClasses() {
        return heroService.getHeroClasses();
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public String handleAuthException(AuthException e) {
        log.error("AuthException: {}", e.getMessage());
        return ExceptionMessage.builder()
                .errorMsg(e.getMessage())
                .exception(e)
                .build()
                .toString();
    }
}
