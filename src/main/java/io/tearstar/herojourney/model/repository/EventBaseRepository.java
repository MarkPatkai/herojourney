package io.tearstar.herojourney.model.repository;


import io.tearstar.herojourney.model.base.event.EventBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventBaseRepository extends JpaRepository<EventBase, Long> {

}
