package io.tearstar.herojourney.model.base.hero;

import io.tearstar.herojourney.model.base.SpellType;
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
public class HeroSpell {
    //TODO: Name, Requirement (stat & value), mod, type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DeveloperField(field = "id", editable = false)
    private Long id;

    @DeveloperField(field = "name", required = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "spell_type_id")
    @DeveloperField(field = "spelltype", required = true, complex = true)
    private SpellType type;
}
