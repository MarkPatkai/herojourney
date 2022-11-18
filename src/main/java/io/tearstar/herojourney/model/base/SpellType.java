package io.tearstar.herojourney.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HERO_SPELL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpellType {
    //TODO: Spell Types (phys, fire, water, lightning, earth, unaspected)
    //TODO: ResistanceType (armor, magic), Potency
}
