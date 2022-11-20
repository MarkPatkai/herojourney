package io.tearstar.herojourney.model.base.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_CONVERSATION_PARTICIPANT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventConversationParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;
}
