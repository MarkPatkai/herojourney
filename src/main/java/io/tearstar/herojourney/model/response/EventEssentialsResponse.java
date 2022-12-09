package io.tearstar.herojourney.model.response;

import io.tearstar.herojourney.model.base.event.EventBase;
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
public class EventEssentialsResponse {

    private EventBase base;

    private List<EventConversation> conversation;

    private List<EventFightEnemies> eventFightEnemies;
}
