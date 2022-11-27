package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.base.hero.HeroSpell;
import io.tearstar.herojourney.model.core.GameObjectField;
import io.tearstar.herojourney.model.repository.hero.HeroSpellRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DeveloperService {

    private HeroSpellRepository heroSpellRepository;

    private HeaderService headerService;


    public DeveloperService(HeroSpellRepository heroSpellRepository, HeaderService headerService) {
        this.heroSpellRepository = heroSpellRepository;
        this.headerService = headerService;
    }

    public List<HeroSpell> getHeroSpells() {
        return heroSpellRepository.findAll();
    }

    public HeroSpell createHeroSpell(@NonNull HeroSpell heroSpell) {
        heroSpellRepository.save(heroSpell);
        return heroSpell;
    }

    public List<GameObjectField> getHeroSpellsMap()
    {
        return headerService.getHeadersForClass(HeroSpell.class);
    }

    public List<GameObjectField> getEnemyBasesMap() {
        return headerService.getHeadersForClass(EnemyBase.class);
    }
}
