package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.repository.HeroRepository;
import io.tearstar.herojourney.model.request.UserHeroRequest;
import io.tearstar.herojourney.model.user.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class HeroService {

    private HeroRepository heroRepository;
    private UserService userService;

    public HeroService(HeroRepository heroRepository, UserService userService) {
        this.heroRepository = heroRepository;
        this.userService = userService;
    }

    public List<Hero> getHeroesByUser(@NonNull User user) {
        log.info("Finding heroes for User({})", user.getUserId());
        return heroRepository.findByOwner(user);
    }

    public Hero createHero(@NonNull UserHeroRequest userHeroRequest) {
        requireNonNull(userHeroRequest.getUser().getId());
        User userById = userService.getUserById(userHeroRequest.getUser().getId());
        requireNonNull(userById);
        userHeroRequest.getHero().setOwner(userById);
        log.info("Creating Hero({}) for User({})", userHeroRequest.getHero().toString(), userById.getUserId());
        return heroRepository.save(userHeroRequest.getHero());
    }
}
