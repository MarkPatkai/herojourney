package io.tearstar.herojourney.model.request;

import io.tearstar.herojourney.model.base.event.EventConversation;
import io.tearstar.herojourney.model.base.event.EventFight;
import io.tearstar.herojourney.model.base.event.EventFightEnemies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventBuilderRequest {

    // event base
    private String name;
    private String description;
    private int requiredLevel;

    // event conversation
    private List<EventConversation> eventConversations;

    private List<EventFight> eventFights;

    private List<EventFightEnemies> eventFightEnemies;
}
