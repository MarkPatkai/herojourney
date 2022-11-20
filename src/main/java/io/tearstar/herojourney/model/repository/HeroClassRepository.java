package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.hero.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroClassRepository extends JpaRepository<HeroClass, Long> {
}
