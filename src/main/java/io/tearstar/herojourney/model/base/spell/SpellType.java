package io.tearstar.herojourney.model.base.spell;

import io.tearstar.herojourney.model.core.DeveloperField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SPELL_TYPE")
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

    @DeveloperField(field = "resistedBy", required = true, complex = true)
    @ManyToOne
    @JoinColumn(name = "resistance_type_id")
    private ResistenceType resistedBy;

}
