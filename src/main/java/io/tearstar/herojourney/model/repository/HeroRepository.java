package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findByOwner(User user);

}
