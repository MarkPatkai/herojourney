package io.tearstar.herojourney.model.base;

import io.tearstar.herojourney.model.core.DeveloperField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HERO_SPELL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpellType {
    //TODO: Spell Types (phys, fire, water, lightning, earth, unaspected)
    //TODO: ResistanceType (armor, magic), Potency

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @DeveloperField(field = "id", editable = false)
    private Long id;

    @DeveloperField(field = "name", required = true)
    private String name;
}
