package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import io.tearstar.herojourney.model.request.EventBuilderRequest;
import io.tearstar.herojourney.model.response.EventEssentialsResponse;
import io.tearstar.herojourney.service.EnemyService;
import io.tearstar.herojourney.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HeroJourney/developer")
@Slf4j
public class DeveloperController {

    private EnemyService enemyService;
    private EventService eventService;

    public DeveloperController(EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    @GetMapping("/")
    public String getDeveloper() {
        return "OK";
    }

    @PostMapping("/event")
    public EventEssentialsResponse createEvent(@RequestBody EventBuilderRequest request) {
        return eventService.processEventBuilderRequest(request);
    }


    @PostMapping("/enemy")
    public EnemyBase createEnemyBase(EnemyBase enemyBase) {
        return enemyService.createEnemyBase(enemyBase);
    }

    @GetMapping("/enemy")
    public List<EnemyBase> getEnemyBases() {
        return enemyService.getEnemyBases();
    }

}
