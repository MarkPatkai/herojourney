package io.tearstar.herojourney.model.repository.hero;

import io.tearstar.herojourney.model.base.hero.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroClassRepository extends JpaRepository<HeroClass, Long> {
}
