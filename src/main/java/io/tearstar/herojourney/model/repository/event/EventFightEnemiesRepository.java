package io.tearstar.herojourney.model.repository.event;

import io.tearstar.herojourney.model.base.event.EventFight;
import io.tearstar.herojourney.model.base.event.EventFightEnemies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventFightEnemiesRepository extends JpaRepository<EventFightEnemies, Long> {

    List<EventFightEnemies> findByEventFight(EventFight eventFight);
}
