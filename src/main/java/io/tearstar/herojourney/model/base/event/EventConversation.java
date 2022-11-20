package io.tearstar.herojourney.model.base.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.core.ConversationParticipant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static java.util.Objects.isNull;

@Entity
@Table(name = "EVENT_CONVERSATION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventConversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EVENT_BASE_ID")
    private EventBase eventBase;

    @ManyToOne
    @JoinColumn(name = "HERO_ID")
    private Hero hero;

    private String text;

    private ConversationParticipant sayer;

    private String partnerName;

    public int order;

    @ManyToOne
    @JoinColumn(name = "EVENT_FIGHT_ID")
    public EventFight eventFight;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean isFight() {
        return isNull(eventFight);
    }
}
