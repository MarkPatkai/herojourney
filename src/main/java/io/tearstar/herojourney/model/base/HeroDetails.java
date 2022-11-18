package io.tearstar.herojourney.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HERO_DETAIL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroDetails {
    //TODO: Inventory (Id list), Resistances (base), Equipment, LearnedSpells (ID list)

}
