package io.tearstar.herojourney.model.repository.event;

import io.tearstar.herojourney.model.base.event.EventBase;
import io.tearstar.herojourney.model.base.event.EventConversationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface EventConversationParticipantRepository extends JpaRepository<EventConversationParticipant, Long> {

}
