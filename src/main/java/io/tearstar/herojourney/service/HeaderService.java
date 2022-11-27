package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.core.DeveloperField;
import io.tearstar.herojourney.model.core.GameObjectField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HeaderService {


    public List<GameObjectField> getHeadersForClass(Class<?> clazz) {
        List<GameObjectField> headers = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            DeveloperField annotation = field.getAnnotation(DeveloperField.class);
            log.info("Field: " + field.getName() + " Annotation: " + annotation);
            if (annotation == null) {
               headers.add(GameObjectField.builder()
                       .name(field.getName())
                       .type(field.getType().getSimpleName())
                       .editable(true)
                       .required(false)
                       .complex(false)
                       .helpText("")
                       .build());
            } else {
                headers.add(GameObjectField.builder()
                        .name(annotation.field().equals("") ? field.getName() : annotation.field())
                        .type(field.getType().getSimpleName())
                        .editable(annotation.editable())
                        .required(annotation.required())
                        .complex(annotation.complex())
                        .helpText(annotation.helpText())
                        .build());
            }
        }


        return headers;
    }
}
