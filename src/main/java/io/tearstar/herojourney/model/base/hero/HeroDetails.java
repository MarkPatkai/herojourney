package io.tearstar.herojourney.model.base.hero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HERO_DETAIL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: Inventory (Id list), Resistances (base), Equipment, LearnedSpells (ID list)


}
