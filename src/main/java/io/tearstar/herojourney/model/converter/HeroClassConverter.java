package io.tearstar.herojourney.model.converter;

import io.tearstar.herojourney.model.base.HeroClass;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class HeroClassConverter implements AttributeConverter<String, HeroClass> {

    @Override
    public HeroClass convertToDatabaseColumn(String attribute) {
        return HeroClass.valueOf(attribute);
    }

    @Override
    public String convertToEntityAttribute(HeroClass dbData) {
        return dbData.getLabel();
    }
}
