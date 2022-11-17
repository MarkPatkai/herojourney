package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.HeroClass;
import io.tearstar.herojourney.model.base.HeroTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroTemplateRepository extends JpaRepository<HeroTemplate, Long> {

    Optional<HeroTemplate> findByName(HeroClass heroClass);

}
