package io.tearstar.herojourney.model.base.hero;

import io.tearstar.herojourney.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HEROES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level = 1;

    private int exp;

    private int str = 2;

    private int dex = 2;

    private int mnd = 2;

    private int vit = 2;

    @ManyToOne
    @JoinColumn(name = "hero_class_id")
    private HeroClass heroClass;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


}
