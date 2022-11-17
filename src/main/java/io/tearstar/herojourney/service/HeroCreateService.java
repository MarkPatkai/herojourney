package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.base.HeroClass;
import io.tearstar.herojourney.model.base.HeroTemplate;
import io.tearstar.herojourney.model.exceptions.DataNotFoundException;
import io.tearstar.herojourney.model.repository.HeroRepository;
import io.tearstar.herojourney.model.repository.HeroTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HeroCreateService {

    private HeroRepository heroRepository;
    private HeroTemplateRepository heroTemplateRepository;

    public HeroCreateService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero createHero(HeroClass heroClass, Hero hero) throws DataNotFoundException {
       HeroTemplate template = heroTemplateRepository
               .findByName(heroClass).orElseThrow(() -> new DataNotFoundException(HeroTemplate.class.getSimpleName()));

       hero.setDex(hero.getDex() + template.getDex());
       hero.setMnd(hero.getMnd() + template.getMnd());
       hero.setStr(hero.getStr() + template.getStr());
       hero.setVit(hero.getVit() + template.getVit());

       return heroRepository.save(hero);
    }

    public HeroTemplate getHeroTemplate(HeroClass heroClass) throws DataNotFoundException {
        return heroTemplateRepository
                .findByName(heroClass).orElseThrow(() -> new DataNotFoundException(HeroTemplate.class.getSimpleName()));
    }
}
