package io.tearstar.herojourney.model.core;

public class AbstractAttributeHolder implements AttributeProxy, AttributeScale {

    protected int getByAttribute(AttributeName attributeName){
        switch (attributeName) {
            case STRENGTH:
                return getStr();
            case VITALITY:
                return getVit();
            case MIND:
                return getMnd();
            case DEXTERITY:
                return getDex();
        }
        throw new EnumConstantNotPresentException(AttributeName.class, attributeName.name());
    }

    @Override
    public int getStr() {
        return 0;
    }

    @Override
    public int getDex() {
        return 0;
    }

    @Override
    public int getVit() {
        return 0;
    }

    @Override
    public int getMnd() {
        return 0;
    }

    @Override
    public AttributeName scalaMod() {
        return null;
    }

    @Override
    public AttributeName scalaSnd() {
        return null;
    }

    @Override
    public int getScalaMod() {
        return 0;
    }

    @Override
    public int getScalaSndMod() {
        return 0;
    }
}
