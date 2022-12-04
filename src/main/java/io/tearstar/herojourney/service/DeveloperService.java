package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import io.tearstar.herojourney.model.base.hero.HeroSpell;
import io.tearstar.herojourney.model.base.spell.SpellType;
import io.tearstar.herojourney.model.core.GameObjectField;
import io.tearstar.herojourney.model.repository.hero.HeroSpellRepository;
import io.tearstar.herojourney.model.repository.spell.SpellTypeRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DeveloperService {

    private HeroSpellRepository heroSpellRepository;
    private SpellTypeRepository spellTypeRepository;

    private HeaderService headerService;


    public DeveloperService(HeroSpellRepository heroSpellRepository, SpellTypeRepository spellTypeRepository,
                            HeaderService headerService) {
        this.heroSpellRepository = heroSpellRepository;
        this.spellTypeRepository = spellTypeRepository;
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

    public List<GameObjectField> getSpellTypeMap() {
        return headerService.getHeadersForClass(SpellType.class);
    }

    public List<SpellType> getSpellTypes() {
        return spellTypeRepository.findAll();
    }
}
