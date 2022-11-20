package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.event.EventBase;
import io.tearstar.herojourney.model.base.event.EventConversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventConversationRepository extends JpaRepository<EventConversation, Long> {

    List<EventConversation> findByEventBase(EventBase eventBase);
}

