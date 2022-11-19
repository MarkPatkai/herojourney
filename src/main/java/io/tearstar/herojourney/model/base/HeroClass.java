package io.tearstar.herojourney.model.base;

import io.tearstar.herojourney.model.core.AbstractAttributeHolder;
import io.tearstar.herojourney.model.core.AttributeName;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "HERO_CLASS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroClass extends AbstractAttributeHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int str;

    private int dex;

    private int mnd;

    private int vit;

}
