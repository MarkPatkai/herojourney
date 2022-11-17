package io.tearstar.herojourney.model.repository;

import io.tearstar.herojourney.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
