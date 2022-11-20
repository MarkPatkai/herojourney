package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.event.EventBase;
import io.tearstar.herojourney.model.base.event.EventFight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventFightRepository extends JpaRepository<EventFight, Long> {

    Optional<EventFight> findByEventBase(EventBase id);
}
