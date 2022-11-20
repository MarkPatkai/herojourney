package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.event.EventBase;
import io.tearstar.herojourney.model.exceptions.EventNotFoundException;
import io.tearstar.herojourney.model.repository.*;
import io.tearstar.herojourney.model.response.EventEssentialsResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventService {

    private EventBaseRepository eventBaseRepository;
    private EventConversationRepository eventConversationRepository;
    private EventFightEnemiesRepository eventFightEnemiesRepository;
    private EventFightRepository eventFightRepository;
    private EnemyBaseRepository enemyBaseRepository;

    public EventService(EventBaseRepository eventBaseRepository, EventConversationRepository eventConversationRepository, EventFightEnemiesRepository eventFightEnemiesRepository, EventFightRepository eventFightRepository, EnemyBaseRepository enemyBaseRepository) {
        this.eventBaseRepository = eventBaseRepository;
        this.eventConversationRepository = eventConversationRepository;
        this.eventFightEnemiesRepository = eventFightEnemiesRepository;
        this.eventFightRepository = eventFightRepository;
        this.enemyBaseRepository = enemyBaseRepository;
    }

    public EventBase getEventBaseById(Long id) throws EventNotFoundException {
        return eventBaseRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id.toString()));
    }

    public EventEssentialsResponse findEvent(@NonNull Long id) throws EventNotFoundException {
        EventBase eventBase = getEventBaseById(id);
        var event = eventConversationRepository.findByEventBase(eventBase);
        var eventFight = eventFightRepository.findByEventBase(eventBase).orElseThrow(() -> new EventNotFoundException(id.toString()));
        var eventFightEnemies = eventFightEnemiesRepository.findByEventFight(eventFight);
        return EventEssentialsResponse
                .builder()
                .base(eventBase)
                .conversation(event)
                .eventFightEnemies(eventFightEnemies)
                .build();
     }

}
