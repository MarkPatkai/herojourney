package io.tearstar.herojourney.model.user;

import io.tearstar.herojourney.model.base.Hero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER_HERO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    public User user;

    @ManyToOne
    @JoinColumn(name = "heroId")
    public Hero hero;
}
