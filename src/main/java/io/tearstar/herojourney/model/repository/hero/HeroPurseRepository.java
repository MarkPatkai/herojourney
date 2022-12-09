package io.tearstar.herojourney.model.repository.hero;

import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.base.hero.HeroPurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroPurseRepository extends JpaRepository<HeroPurse, Long> {

    HeroPurse findByOwner(Hero hero);
}
