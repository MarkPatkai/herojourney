package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import io.tearstar.herojourney.model.base.hero.HeroSpell;
import io.tearstar.herojourney.model.base.spell.SpellType;
import io.tearstar.herojourney.model.core.GameObjectField;
import io.tearstar.herojourney.model.request.EventBuilderRequest;
import io.tearstar.herojourney.model.response.EventEssentialsResponse;
import io.tearstar.herojourney.service.DeveloperService;
import io.tearstar.herojourney.service.EnemyService;
import io.tearstar.herojourney.service.EventService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HeroJourney/developer")
@Slf4j
public class DeveloperController {

    private EnemyService enemyService;
    private EventService eventService;

    private DeveloperService developerService;


    public DeveloperController(EnemyService enemyService, EventService eventService, DeveloperService developerService) {
        this.enemyService = enemyService;
        this.eventService = eventService;
        this.developerService = developerService;
    }

    @GetMapping("/")
    public String getDeveloper() {
        return "OK";
    }

    @PostMapping("/event")
    public EventEssentialsResponse createEvent(@RequestBody EventBuilderRequest request) {
        return eventService.processEventBuilderRequest(request);
    }

    @GetMapping("/event")
    public List<EventEssentialsResponse> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/event/headers")
    public List<String> getEventHeaders() {
        return eventService.getEventHeaders();
    }

    @PostMapping("/enemy")
    public EnemyBase createEnemyBase(EnemyBase enemyBase) {
        return enemyService.createEnemyBase(enemyBase);
    }

    @GetMapping("/enemy")
    public List<EnemyBase> getEnemyBases() {
        return enemyService.getEnemyBases();
    }

    @GetMapping("/enemy/headers")
    public List<GameObjectField> getEnemyBasesMap() {
        return developerService.getEnemyBasesMap();
    }

    @GetMapping("/spell")
    public List<HeroSpell> getHeroSpells() {
        return developerService.getHeroSpells();
    }
    @PostMapping("/spell")
    public HeroSpell createHeroSpell(@NonNull HeroSpell heroSpell) {
        return developerService.createHeroSpell(heroSpell);
    }

    @GetMapping("/spell/headers")
    public List<GameObjectField> getHeroSpellsHeaders() {
        return developerService.getHeroSpellsMap();
    }

    @GetMapping("/spellType/headers")
    public List<GameObjectField> getSpellTypeHeaders() {
        return developerService.getSpellTypeMap();
    }
    @GetMapping("/spellType")
    public List<SpellType> getSpellType() {
        return developerService.getSpellTypes();
    }
}
