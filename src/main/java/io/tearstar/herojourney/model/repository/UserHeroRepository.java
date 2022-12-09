package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.user.UserHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHeroRepository extends JpaRepository<UserHero, Long> {
}
