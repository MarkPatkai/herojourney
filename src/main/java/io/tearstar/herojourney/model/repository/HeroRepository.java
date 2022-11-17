package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {


}
