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
public class HeroSpell {
    //TODO: Name, Requirement (stat & value), mod, type
}
