package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.base.hero.HeroClass;
import io.tearstar.herojourney.model.base.hero.HeroPurse;
import io.tearstar.herojourney.model.exceptions.DataNotFoundException;
import io.tearstar.herojourney.model.repository.hero.HeroClassRepository;
import io.tearstar.herojourney.model.repository.hero.HeroPurseRepository;
import io.tearstar.herojourney.model.repository.hero.HeroRepository;
import io.tearstar.herojourney.model.user.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class HeroService {

    private HeroRepository heroRepository;
    private UserService userService;

    private HeroPurseRepository heroPurseRepository;
    private HeroClassRepository heroClassRepository;

    public HeroService(HeroRepository heroRepository, UserService userService,
                       HeroPurseRepository heroPurseRepository, HeroClassRepository heroClassRepository) {
        this.heroRepository = heroRepository;
        this.userService = userService;
        this.heroPurseRepository = heroPurseRepository;
        this.heroClassRepository = heroClassRepository;
    }

    public List<Hero> getHeroesByUser(@NonNull User user) {
        log.info("Finding heroes for User({})", user.getUserId());
        return heroRepository.findByOwner(user);
    }

    public Hero createHero(@NonNull Hero hero) {
        log.info("Creating hero: {}", hero);
        SecurityContext context = SecurityContextHolder.getContext();
        log.info("User: {}", context.getAuthentication());
        User user = (User) context.getAuthentication().getPrincipal();
        hero.setOwner(user);
        hero.setDex(hero.getDex() + hero.getHeroClass().getDex());
        hero.setStr(hero.getStr() + hero.getHeroClass().getStr());
        hero.setVit(hero.getVit() + hero.getHeroClass().getVit());
        hero.setMnd(hero.getMnd() + hero.getHeroClass().getMnd());
        return heroRepository.save(hero);
    }

    public List<HeroClass> getHeroClasses() {
        return heroClassRepository.findAll();
    }

    public HeroPurse getHeroPurse(@NonNull Long heroId) throws DataNotFoundException {
        Hero hero = heroRepository.findById(heroId).orElseThrow(() -> new DataNotFoundException(heroId.toString()));
        HeroPurse purse = heroPurseRepository.findByOwner(hero);
        if(purse == null) {
            purse = new HeroPurse();
        }
        purse.setOwner(hero);
        return heroPurseRepository.save(purse);
    }
}
