package io.tearstar.herojourney.model.repository.spell;

import io.tearstar.herojourney.model.base.spell.SpellType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellTypeRepository extends JpaRepository<SpellType, Long> {
}

