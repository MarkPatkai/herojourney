package io.tearstar.herojourney.model.base;

import lombok.Getter;

public enum HeroClass {

    WARRIOR("Warrior"),
    MAGE("Mage"),
    ASSASSIN("Assassin");


    @Getter
    private String label;

    HeroClass(String label) {
        this.label = label;
    }


}
