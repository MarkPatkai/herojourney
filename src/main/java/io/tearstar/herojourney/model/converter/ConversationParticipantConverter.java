package io.tearstar.herojourney.model.converter;

import io.tearstar.herojourney.model.base.event.EventConversationParticipant;
import io.tearstar.herojourney.model.core.ConversationParticipant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConversationParticipantConverter
        implements AttributeConverter<EventConversationParticipant, ConversationParticipant> {

    @Override
    public ConversationParticipant convertToDatabaseColumn(EventConversationParticipant attribute) {
        return ConversationParticipant.fromValue(attribute.getName());
    }

    @Override
    public EventConversationParticipant convertToEntityAttribute(ConversationParticipant dbData) {
        return EventConversationParticipant.builder().name(dbData.value()).build();
    }

}
