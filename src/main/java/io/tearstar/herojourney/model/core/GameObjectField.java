package io.tearstar.herojourney.model.core;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameObjectField {

    private String name;
    private String type;
    private boolean editable;
    private boolean required;
    private boolean complex;
    private String helpText;
}
