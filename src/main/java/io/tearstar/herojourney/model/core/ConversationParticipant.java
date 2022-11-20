package io.tearstar.herojourney.model.core;


import lombok.Getter;

public enum ConversationParticipant {
    HERO("Hero"),
    NPC("NPC"),
    NARRATOR("Narrator");

    @Getter
    private String name;

    ConversationParticipant(String name) {
        this.name = name;
    }

    public String value() {
        return name();
    }

    public static ConversationParticipant fromValue(String v) {
        return valueOf(v);
    }



}
